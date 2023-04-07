package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class Bed extends PacketAccessor {
    public Bed(Object handle) {
        super(PacketType.Play.Server.BED, handle);
    }

    public Bed() {
        super(PacketType.Play.Server.BED);
    }

    public int getEntityId() {
        return this.get(0);
    }

    public void setEntityId(int value) {
        this.set(0, value);
    }

    public Object getPosition() {
        return this.get(1);
    }

    public void setPosition(Object value) {
        this.set(1, value);
    }
}
