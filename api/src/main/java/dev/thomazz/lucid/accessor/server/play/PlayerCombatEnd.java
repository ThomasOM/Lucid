package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#PLAYER_COMBAT_END}
* Some types in getters and setters may not be supported properly yet.
*/
public final class PlayerCombatEnd extends PacketAccessor {
    public PlayerCombatEnd(Object handle) {
        super(PacketType.Play.Server.PLAYER_COMBAT_END, handle);
    }

    public PlayerCombatEnd() {
        super(PacketType.Play.Server.PLAYER_COMBAT_END);
    }

    public int getKillerId() {
        return this.get(0);
    }

    public void setKillerId(int value) {
        this.set(0, value);
    }

    public int getDuration() {
        return this.get(1);
    }

    public void setDuration(int value) {
        this.set(1, value);
    }
}
