package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

import java.util.List;

@Deprecated
public final class PlayerInfo extends PacketAccessor {
    public PlayerInfo(Object handle) {
        super(PacketType.Play.Server.PLAYER_INFO, handle);
    }

    public PlayerInfo() {
        super(PacketType.Play.Server.PLAYER_INFO);
    }

    public Object getAction() {
        return this.get(0);
    }

    public void setAction(Object value) {
        this.set(0, value);
    }

    public List<?> getData() {
        return this.get(1);
    }

    public void setData(List<?> value) {
        this.set(1, value);
    }
}

