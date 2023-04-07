package dev.thomazz.lucid.inject;

import dev.thomazz.lucid.channel.ChannelAccess;

/**
 * Base interface for injecting the API into the server dynamically.
 */
public interface Injector {
    /**
     * Injects into the server.
     *
     * @param access - Channel networking access
     */
    void inject(ChannelAccess access);

    /**
     * Ejects from the server.
     *
     * @param access - Channel networking access
     */
    void eject(ChannelAccess access);
}
