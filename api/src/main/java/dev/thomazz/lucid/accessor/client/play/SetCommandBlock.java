package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#SET_COMMAND_BLOCK}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetCommandBlock extends PacketAccessor {
    public SetCommandBlock(Object handle) {
        super(PacketType.Play.Client.SET_COMMAND_BLOCK, handle);
    }

    public SetCommandBlock() {
        super(PacketType.Play.Client.SET_COMMAND_BLOCK);
    }

    public Object getPos() {
        return this.get(3);
    }

    public void setPos(Object value) {
        this.set(3, value);
    }

    public String getCommand() {
        return this.get(4);
    }

    public void setCommand(String value) {
        this.set(4, value);
    }

    public boolean getTrackOutput() {
        return this.get(5);
    }

    public void setTrackOutput(boolean value) {
        this.set(5, value);
    }

    public boolean getConditional() {
        return this.get(6);
    }

    public void setConditional(boolean value) {
        this.set(6, value);
    }

    public boolean getAutomatic() {
        return this.get(7);
    }

    public void setAutomatic(boolean value) {
        this.set(7, value);
    }

    public Object getMode() {
        return this.get(8);
    }

    public void setMode(Object value) {
        this.set(8, value);
    }
}