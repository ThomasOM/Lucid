package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#BLOCK_BREAK_ANIMATION}
* Some types in getters and setters may not be supported properly yet.
*/
public final class BlockBreakAnimation extends PacketAccessor {
    public BlockBreakAnimation(Object handle) {
        super(PacketType.Play.Server.BLOCK_BREAK_ANIMATION, handle);
    }

    public BlockBreakAnimation() {
        super(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
    }

    public int getId() {
        return this.get(0);
    }

    public void setId(int value) {
        this.set(0, value);
    }

    public Object getPos() {
        return this.get(1);
    }

    public void setPos(Object value) {
        this.set(1, value);
    }

    public int getProgress() {
        return this.get(2);
    }

    public void setProgress(int value) {
        this.set(2, value);
    }
}
