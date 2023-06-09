package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#ENTITY_NBT_QUERY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class EntityNBTQuery extends PacketAccessor {
    public EntityNBTQuery(Object handle) {
        super(PacketType.Play.Client.ENTITY_NBT_QUERY, handle);
    }

    public EntityNBTQuery() {
        super(PacketType.Play.Client.ENTITY_NBT_QUERY);
    }

    public int getTransactionId() {
        return this.get(0);
    }

    public void setTransactionId(int value) {
        this.set(0, value);
    }

    public int getEntityId() {
        return this.get(1);
    }

    public void setEntityId(int value) {
        this.set(1, value);
    }
}
