package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#TELEPORT_ACCEPT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class TeleportAccept extends PacketAccessor {
    public TeleportAccept(Object handle) {
        super(PacketType.Play.Client.TELEPORT_ACCEPT, handle);
    }

    public TeleportAccept() {
        super(PacketType.Play.Client.TELEPORT_ACCEPT);
    }

    public int getId() {
        return this.get(0);
    }

    public void setId(int value) {
        this.set(0, value);
    }
}
