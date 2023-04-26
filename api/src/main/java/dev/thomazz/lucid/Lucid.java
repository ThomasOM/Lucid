package dev.thomazz.lucid;

import dev.thomazz.lucid.channel.ChannelAccess;
import dev.thomazz.lucid.channel.ReflectiveChannelAccess;
import dev.thomazz.lucid.inject.Injector;
import dev.thomazz.lucid.inject.connection.ServerConnectionInjector;
import dev.thomazz.lucid.packet.PacketIterable;
import dev.thomazz.lucid.packet.PacketType;
import dev.thomazz.lucid.player.PlayerManager;
import java.util.Collection;
import java.util.stream.Collectors;

import dev.thomazz.lucid.version.MinecraftVersion;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main API object for Lucid.
 * Use {@link Lucid#create()} for creating a new instance.
 * The instance can be started with {@link Lucid#start(JavaPlugin)}
 */
@Getter
@RequiredArgsConstructor
public final class Lucid {
    private static Lucid instance;

    private final Injector injector;
    private final PlayerManager playerManager;
    private final ChannelAccess channelAccess;

    private JavaPlugin plugin;
    private boolean destroyed;

    private Lucid(Injector injector) {
        this.injector = injector;
        this.playerManager = new PlayerManager(this);
        this.channelAccess = new ReflectiveChannelAccess();
    }
    
    public Lucid start(JavaPlugin plugin) {
        if (this.destroyed) {
            throw new IllegalStateException("Can not re-use the same instance after destroying it!");
        }

        MinecraftVersion.init(plugin);

        this.plugin = plugin;
        this.plugin.getLogger().info("[Lucid] Starting Lucid Packet API");

        this.plugin.getServer().getPluginManager().registerEvents(this.playerManager, this.plugin);
        this.injector.inject(this.channelAccess);

        Collection<PacketType> allTypes = PacketType.iterables().stream()
                .flatMap(PacketIterable::stream)
                .collect(Collectors.toList());

        long loaded = allTypes.stream().filter(PacketType::isLoaded).count();
        this.plugin.getLogger().info("[Lucid] Loaded " + loaded + "/" + allTypes.size() + " packet types");
        return this;
    }

    public void destroy() {
        this.plugin.getLogger().info("[Lucid] Stopping Lucid Packet API");

        this.injector.eject(this.channelAccess);
        HandlerList.unregisterAll(this.playerManager);

        this.destroyed = true;
        Lucid.instance = null;
    }

    public static Lucid get() {
        return instance;
    }

    public static Lucid create() {
        return create(new ServerConnectionInjector());
    }

    // If you want to use a custom injector for some reason
    public static Lucid create(Injector injector) {
        if (Lucid.instance != null) {
            throw new IllegalStateException("Lucid API instance is already running!");
        }

        Lucid.instance = new Lucid(injector);
        return Lucid.instance;
    }
}
