package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class WorldBorder extends PacketAccessor {
    public WorldBorder(Object handle) {
        super(PacketType.Play.Server.WORLD_BORDER, handle);
    }

    public WorldBorder() {
        super(PacketType.Play.Server.WORLD_BORDER);
    }

    public Object getAction() {
        return this.get(0);
    }

    public void setAction(Object value) {
        this.set(0, value);
    }

    public int getPortalTeleportWarning() {
        return this.get(1);
    }

    public void setPortalTeleportWarning(int value) {
        this.set(1, value);
    }

    public double getCenterX() {
        return this.get(2);
    }

    public void setCenterX(double value) {
        this.set(2, value);
    }

    public double getCenterZ() {
        return this.get(3);
    }

    public void setCenterZ(double value) {
        this.set(3, value);
    }

    public void getOldSize(double value) {
        this.set(4, value);
    }

    public double setOldSize() {
        return this.get(4);
    }

    public void getSize(double value) {
        this.set(5, value);
    }

    public double setSize() {
        return this.get(5);
    }

    public void getSpeed(long value) {
        this.set(6, value);
    }

    public long setSpeed() {
        return this.get(6);
    }

    public int getWarningTime() {
        return this.get(7);
    }

    public void setWarningTime(int value) {
        this.set(7, value);
    }

    public int getWarningDistance() {
        return this.get(8);
    }

    public void setWarningDistance(int value) {
        this.set(8, value);
    }
}
