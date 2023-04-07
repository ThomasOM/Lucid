package dev.thomazz.lucid.inject.connection;

import dev.thomazz.lucid.channel.ChannelAccess;
import dev.thomazz.lucid.channel.LucidChannelHandler;
import dev.thomazz.lucid.inject.Injector;
import dev.thomazz.lucid.util.ListWrapper;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.ReflectionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation that injects into the server connection and all its child handlers directly.
 */
@SuppressWarnings("unchecked")
public class ServerConnectionInjector implements Injector {
    private final List<ChannelFuture> futures = new ArrayList<>();
    private Field injected;
    private Object original;

    @Override
    public void inject(ChannelAccess access) {
        try {
            Object connection = MinecraftReflection.getServerConnection();

            for (Field field : connection.getClass().getDeclaredFields()) {
                if (!List.class.isAssignableFrom(field.getType()) || !field.getGenericType().getTypeName().contains(ChannelFuture.class.getName())) {
                    continue;
                }

                field.setAccessible(true);

                List<ChannelFuture> list = Collections.synchronizedList((List<ChannelFuture>) field.get(connection));
                ListWrapper<ChannelFuture> listWrapper = new ListWrapper<>(list, this::injectChannelFuture);
                listWrapper.forEach(this::injectChannelFuture);
                field.set(connection, listWrapper);

                this.injected = field;
                this.original = list;
            }

            for (Channel channel : access.getAllChannels()) {
                try {
                    channel.pipeline().addBefore("packet_handler", "mini-packet-handler", new LucidChannelHandler());
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Unable to inject!", ex);
        }
    }

    @Override
    public void eject(ChannelAccess access) {
        try {
            Object connection = MinecraftReflection.getServerConnection();

            if (this.injected != null) {
                this.injected.set(connection, this.original);
            }

            for (ChannelFuture future : this.futures) {
                try {
                    ChannelHandler bootstrap = future.channel().pipeline().first();
                    Field childHandlerField = ReflectionUtil.getFieldByName(bootstrap.getClass(), "childHandler");
                    InjectChannelInitializer injected = (InjectChannelInitializer) childHandlerField.get(bootstrap);
                    childHandlerField.set(bootstrap, injected.getParent());
                } catch (Exception ignored) {
                }
            }


            for (Channel channel : access.getAllChannels()) {
                try {
                    channel.pipeline().remove("mini-packet-handler");
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Unable to eject!", ex);
        }
    }

    private void injectChannelFuture(ChannelFuture future) {
        List<String> names = future.channel().pipeline().names();
        ChannelHandler bootstrap = null;

        for (String name : names) {
            ChannelHandler handler = future.channel().pipeline().get(name);
            try {
                ReflectionUtil.getFieldByName(handler.getClass(), "childHandler");
                bootstrap = handler;
                break;
            } catch (ReflectiveOperationException ignored) {
            }
        }

        if (bootstrap == null) {
            bootstrap = future.channel().pipeline().first();
        }

        try {
            Field childHandlerField = ReflectionUtil.getFieldByName(bootstrap.getClass(), "childHandler");
            ChannelInitializer<Channel> oldInitializer = (ChannelInitializer<Channel>) childHandlerField.get(bootstrap);
            childHandlerField.set(bootstrap, new InjectChannelInitializer(oldInitializer));
            this.futures.add(future);
        } catch (Exception ex) {
            throw new RuntimeException("Could not inject into bootstrap!", ex);
        }
    }
}
