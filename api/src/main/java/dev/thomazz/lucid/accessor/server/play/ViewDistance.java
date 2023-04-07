package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#VIEW_DISTANCE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ViewDistance extends PacketAccessor {
    public ViewDistance(Object handle) {
        super(PacketType.Play.Server.VIEW_DISTANCE, handle);
    }

    public ViewDistance() {
        super(PacketType.Play.Server.VIEW_DISTANCE);
    }

    public int getRadius() {
        return this.get(0);
    }

    public void setRadius(int value) {
        this.set(0, value);
    }
}
