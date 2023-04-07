package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#CLIENT_COMMAND}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ClientCommand extends PacketAccessor {
    public ClientCommand(Object handle) {
        super(PacketType.Play.Client.CLIENT_COMMAND, handle);
    }

    public ClientCommand() {
        super(PacketType.Play.Client.CLIENT_COMMAND);
    }

    public Object getAction() {
        return this.get(0);
    }

    public void setAction(Object value) {
        this.set(0, value);
    }
}