package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#OPEN_SIGN_EDITOR}
* Some types in getters and setters may not be supported properly yet.
*/
public final class OpenSignEditor extends PacketAccessor {
    public OpenSignEditor(Object handle) {
        super(PacketType.Play.Server.OPEN_SIGN_EDITOR, handle);
    }

    public OpenSignEditor() {
        super(PacketType.Play.Server.OPEN_SIGN_EDITOR);
    }

    public Object getPos() {
        return this.get(0);
    }

    public void setPos(Object value) {
        this.set(0, value);
    }
}
