package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#SET_CREATIVE_SLOT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetCreativeSlot extends PacketAccessor {
    public SetCreativeSlot(Object handle) {
        super(PacketType.Play.Client.SET_CREATIVE_SLOT, handle);
    }

    public SetCreativeSlot() {
        super(PacketType.Play.Client.SET_CREATIVE_SLOT);
    }

    public int getSlotNum() {
        return this.get(0);
    }

    public void setSlotNum(int value) {
        this.set(0, value);
    }

    public Object getItemStack() {
        return this.get(1);
    }

    public void setItemStack(Object value) {
        this.set(1, value);
    }
}