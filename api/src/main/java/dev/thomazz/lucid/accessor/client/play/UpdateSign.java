package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#UPDATE_SIGN}
* Some types in getters and setters may not be supported properly yet.
*/
public final class UpdateSign extends PacketAccessor {
    public UpdateSign(Object handle) {
        super(PacketType.Play.Client.UPDATE_SIGN, handle);
    }

    public UpdateSign() {
        super(PacketType.Play.Client.UPDATE_SIGN);
    }

    public Object getPos() {
        return this.get(1);
    }

    public void setPos(Object value) {
        this.set(1, value);
    }

    public String[] getLines() {
        return this.get(2);
    }

    public void setLines(String[] value) {
        this.set(2, value);
    }
}
