package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#DISGUISED_CHAT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class DisguisedChat extends PacketAccessor {
    public DisguisedChat(Object handle) {
        super(PacketType.Play.Server.DISGUISED_CHAT, handle);
    }

    public DisguisedChat() {
        super(PacketType.Play.Server.DISGUISED_CHAT);
    }

    public Object getMessage() {
        return this.get(0);
    }

    public void setMessage(Object value) {
        this.set(0, value);
    }

    public Object getChatType() {
        return this.get(1);
    }

    public void setChatType(Object value) {
        this.set(1, value);
    }
}
