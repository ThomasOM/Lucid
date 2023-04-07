package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#JIGSAW_GENERATE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class JigsawGenerate extends PacketAccessor {
    public JigsawGenerate(Object handle) {
        super(PacketType.Play.Client.JIGSAW_GENERATE, handle);
    }

    public JigsawGenerate() {
        super(PacketType.Play.Client.JIGSAW_GENERATE);
    }

    public Object getPos() {
        return this.get(0);
    }

    public void setPos(Object value) {
        this.set(0, value);
    }

    public int getLevels() {
        return this.get(1);
    }

    public void setLevels(int value) {
        this.set(1, value);
    }

    public boolean getKeepJigsaws() {
        return this.get(2);
    }

    public void setKeepJigsaws(boolean value) {
        this.set(2, value);
    }
}