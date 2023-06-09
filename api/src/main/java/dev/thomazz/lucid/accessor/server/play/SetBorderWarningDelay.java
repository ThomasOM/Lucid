package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SET_BORDER_WARNING_DELAY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetBorderWarningDelay extends PacketAccessor {
    public SetBorderWarningDelay(Object handle) {
        super(PacketType.Play.Server.SET_BORDER_WARNING_DELAY, handle);
    }

    public SetBorderWarningDelay() {
        super(PacketType.Play.Server.SET_BORDER_WARNING_DELAY);
    }

    public int getWarningDelay() {
        return this.get(0);
    }

    public void setWarningDelay(int value) {
        this.set(0, value);
    }
}
