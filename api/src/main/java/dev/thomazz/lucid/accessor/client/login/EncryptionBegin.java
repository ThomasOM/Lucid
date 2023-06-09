package dev.thomazz.lucid.accessor.client.login;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Login.Client#ENCRYPTION_BEGIN}
* Some types in getters and setters may not be supported properly yet.
*/
public final class EncryptionBegin extends PacketAccessor {
    public EncryptionBegin(Object handle) {
        super(PacketType.Login.Client.ENCRYPTION_BEGIN, handle);
    }

    public EncryptionBegin() {
        super(PacketType.Login.Client.ENCRYPTION_BEGIN);
    }

    public byte[] getKeybytes() {
        return this.get(0);
    }

    public void setKeybytes(byte[] value) {
        this.set(0, value);
    }

    public byte[] getEncryptedChallenge() {
        return this.get(1);
    }

    public void setEncryptedChallenge(byte[] value) {
        this.set(1, value);
    }
}
