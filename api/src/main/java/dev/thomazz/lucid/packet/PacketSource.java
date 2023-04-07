package dev.thomazz.lucid.packet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines the source the packet is coming from.
 * {@link PacketSource#SERVER} is sent by the server and received by the client.
 * {@link PacketSource#CLIENT} is sent by the client and received by the server.
 */
@Getter
@RequiredArgsConstructor
public enum PacketSource {
    UNKNOWN("Unknown","Unknown"),
    CLIENT("Serverbound","In"),
    SERVER("Clientbound","Out");

    private final String name;
    private final String nameLegacy;
}
