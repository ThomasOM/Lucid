package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#CHAT_ACK}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ChatAck extends PacketAccessor {
    public ChatAck(Object handle) {
        super(PacketType.Play.Client.CHAT_ACK, handle);
    }

    public ChatAck() {
        super(PacketType.Play.Client.CHAT_ACK);
    }

    public int getOffset() {
        return this.get(0);
    }

    public void setOffset(int value) {
        this.set(0, value);
    }
}