package dev.thomazz.lucid.inject.connection;

import dev.thomazz.lucid.channel.LucidChannelHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import java.lang.reflect.Method;

public class InjectChannelInitializer extends ChannelInitializer<Channel> {
    private final ChannelInitializer<Channel> parent;

    public InjectChannelInitializer(ChannelInitializer<Channel> parent) {
        this.parent = parent;
    }

    public ChannelInitializer<Channel> getParent() {
        return this.parent;
    }

    protected void initChannel(Channel channel) throws Exception {
        Method initChannel = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class);
        initChannel.setAccessible(true);
        initChannel.invoke(this.parent, channel);
        channel.pipeline().addBefore("packet_handler", LucidChannelHandler.HANDLER_NAME, new LucidChannelHandler());
    }
}
