package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SET_SIMULATION_DISTANCE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetSimulationDistance extends PacketAccessor {
    public SetSimulationDistance(Object handle) {
        super(PacketType.Play.Server.SET_SIMULATION_DISTANCE, handle);
    }

    public SetSimulationDistance() {
        super(PacketType.Play.Server.SET_SIMULATION_DISTANCE);
    }

    public int getSimulationDistance() {
        return this.get(0);
    }

    public void setSimulationDistance(int value) {
        this.set(0, value);
    }
}