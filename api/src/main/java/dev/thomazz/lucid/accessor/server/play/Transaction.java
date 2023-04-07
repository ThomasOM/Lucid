package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class Transaction extends PacketAccessor {
    public Transaction(Object handle) {
        super(PacketType.Play.Server.TRANSACTION, handle);
    }

    public Transaction() {
        super(PacketType.Play.Server.TRANSACTION);
    }

    public int getWindowId() {
        return this.get(0);
    }

    public void setWindowId(int value) {
        this.set(0, value);
    }

    public short getActionNumber() {
        return this.get(1);
    }

    public void setActionNumber(short value) {
        this.set(1, value);
    }

    public boolean getAccepted() {
        return this.get(2);
    }

    public void setAccepted(boolean value) {
        this.set(2, value);
    }
}
