package dev.thomazz.lucid.accessor.server.status;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Status.Server#SERVER_INFO}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ServerInfo extends PacketAccessor {
    public ServerInfo(Object handle) {
        super(PacketType.Status.Server.SERVER_INFO, handle);
    }

    public ServerInfo() {
        super(PacketType.Status.Server.SERVER_INFO);
    }

    public Object getStatus() {
        return this.get(0);
    }

    public void setStatus(Object value) {
        this.set(0, value);
    }
}
