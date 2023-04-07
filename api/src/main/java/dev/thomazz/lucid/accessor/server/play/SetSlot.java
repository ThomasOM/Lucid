package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SET_SLOT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetSlot extends PacketAccessor {
    public SetSlot(Object handle) {
        super(PacketType.Play.Server.SET_SLOT, handle);
    }

    public SetSlot() {
        super(PacketType.Play.Server.SET_SLOT);
    }

    public int getContainerId() {
        return this.get(2);
    }

    public void setContainerId(int value) {
        this.set(2, value);
    }

    public int getStateId() {
        return this.get(3);
    }

    public void setStateId(int value) {
        this.set(3, value);
    }

    public int getSlot() {
        return this.get(4);
    }

    public void setSlot(int value) {
        this.set(4, value);
    }

    public Object getItemStack() {
        return this.get(5);
    }

    public void setItemStack(Object value) {
        this.set(5, value);
    }
}
