package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#ENTITY_DESTROY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class EntityDestroy extends PacketAccessor {
    public EntityDestroy(Object handle) {
        super(PacketType.Play.Server.ENTITY_DESTROY, handle);
    }

    public EntityDestroy() {
        super(PacketType.Play.Server.ENTITY_DESTROY);
    }

    public Object getEntityIds() {
        return this.get(0);
    }

    public void setEntityIds(Object value) {
        this.set(0, value);
    }
}