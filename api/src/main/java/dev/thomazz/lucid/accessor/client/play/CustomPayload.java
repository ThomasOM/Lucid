package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#CUSTOM_PAYLOAD}
* Some types in getters and setters may not be supported properly yet.
*/
public final class CustomPayload extends PacketAccessor {
    public CustomPayload(Object handle) {
        super(PacketType.Play.Client.CUSTOM_PAYLOAD, handle);
    }

    public CustomPayload() {
        super(PacketType.Play.Client.CUSTOM_PAYLOAD);
    }

    public Object getIdentifier() {
        return this.get(2);
    }

    public void setIdentifier(Object value) {
        this.set(2, value);
    }

    public Object getData() {
        return this.get(3);
    }

    public void setData(Object value) {
        this.set(3, value);
    }
}
