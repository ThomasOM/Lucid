package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#DELETE_CHAT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class DeleteChat extends PacketAccessor {
    public DeleteChat(Object handle) {
        super(PacketType.Play.Server.DELETE_CHAT, handle);
    }

    public DeleteChat() {
        super(PacketType.Play.Server.DELETE_CHAT);
    }

    public Object getMessageSignature() {
        return this.get(0);
    }

    public void setMessageSignature(Object value) {
        this.set(0, value);
    }
}
