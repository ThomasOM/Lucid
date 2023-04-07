package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#REL_ENTITY_MOVE_LOOK}
* Some types in getters and setters may not be supported properly yet.
*/
public final class RelEntityMoveLook extends PacketAccessor {
    public RelEntityMoveLook(Object handle) {
        super(PacketType.Play.Server.REL_ENTITY_MOVE_LOOK, handle);
    }

    public RelEntityMoveLook() {
        super(PacketType.Play.Server.REL_ENTITY_MOVE_LOOK);
    }

    public int getEntityId() {
        return this.get(0);
    }

    public void setEntityId(int value) {
        this.set(0, value);
    }

    public short getXa() {
        return this.get(1);
    }

    public void setXa(short value) {
        this.set(1, value);
    }

    public short getYa() {
        return this.get(2);
    }

    public void setYa(short value) {
        this.set(2, value);
    }

    public short getZa() {
        return this.get(3);
    }

    public void setZa(short value) {
        this.set(3, value);
    }

    public byte getYRot() {
        return this.get(4);
    }

    public void setYRot(byte value) {
        this.set(4, value);
    }

    public byte getXRot() {
        return this.get(5);
    }

    public void setXRot(byte value) {
        this.set(5, value);
    }

    public boolean getOnGround() {
        return this.get(6);
    }

    public void setOnGround(boolean value) {
        this.set(6, value);
    }

    public boolean getHasRot() {
        return this.get(7);
    }

    public void setHasRot(boolean value) {
        this.set(7, value);
    }

    public boolean getHasPos() {
        return this.get(8);
    }

    public void setHasPos(boolean value) {
        this.set(8, value);
    }
}