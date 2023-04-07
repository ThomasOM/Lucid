package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class Chat extends PacketAccessor {
    public Chat(Object handle) {
        super(PacketType.Play.Server.CHAT, handle);
    }

    public Chat() {
        super(PacketType.Play.Server.CHAT);
    }

    public Object getComponent() {
        return this.get(0);
    }

    public void setComponent(Object value) {
        this.set(0, value);
    }

    public byte getPosition() {
        return this.get(2);
    }

    public void setPosition(Object value) {
        this.set(2, value);
    }
}
