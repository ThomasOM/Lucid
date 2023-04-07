package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import java.util.Map;
import java.util.Set;
import java.util.Map;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#ADVANCEMENTS}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Advancements extends PacketAccessor {
    public Advancements(Object handle) {
        super(PacketType.Play.Server.ADVANCEMENTS, handle);
    }

    public Advancements() {
        super(PacketType.Play.Server.ADVANCEMENTS);
    }

    public boolean getReset() {
        return this.get(0);
    }

    public void setReset(boolean value) {
        this.set(0, value);
    }

    public Map getAdded() {
        return this.get(1);
    }

    public void setAdded(Map value) {
        this.set(1, value);
    }

    public Set getRemoved() {
        return this.get(2);
    }

    public void setRemoved(Set value) {
        this.set(2, value);
    }

    public Map getProgress() {
        return this.get(3);
    }

    public void setProgress(Map value) {
        this.set(3, value);
    }
}