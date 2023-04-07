package dev.thomazz.lucid.packet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines the game state for a packet
 */
@Getter
@RequiredArgsConstructor
public enum PacketState {
    UNKNOWN("unknown", "unknown"),
    HANDSHAKE("handshake", "Handshaking"),
    STATUS("status", "Status"),
    LOGIN("login", "Login"),
    PLAY("game", "Play");

    private final String name;
    private final String nameLegacy;
}
