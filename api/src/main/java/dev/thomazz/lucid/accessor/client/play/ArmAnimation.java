package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#ARM_ANIMATION}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ArmAnimation extends PacketAccessor {
    public ArmAnimation(Object handle) {
        super(PacketType.Play.Client.ARM_ANIMATION, handle);
    }

    public ArmAnimation() {
        super(PacketType.Play.Client.ARM_ANIMATION);
    }

    public Object getHand() {
        return this.get(0);
    }

    public void setHand(Object value) {
        this.set(0, value);
    }
}
