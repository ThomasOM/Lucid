package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SCOREBOARD_SCORE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ScoreboardScore extends PacketAccessor {
    public ScoreboardScore(Object handle) {
        super(PacketType.Play.Server.SCOREBOARD_SCORE, handle);
    }

    public ScoreboardScore() {
        super(PacketType.Play.Server.SCOREBOARD_SCORE);
    }

    public String getOwner() {
        return this.get(0);
    }

    public void setOwner(String value) {
        this.set(0, value);
    }

    public String getObjectiveName() {
        return this.get(1);
    }

    public void setObjectiveName(String value) {
        this.set(1, value);
    }

    public int getScore() {
        return this.get(2);
    }

    public void setScore(int value) {
        this.set(2, value);
    }

    public Object getMethod() {
        return this.get(3);
    }

    public void setMethod(Object value) {
        this.set(3, value);
    }
}
