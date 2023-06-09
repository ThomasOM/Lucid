package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import java.util.List;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#CUSTOM_CHAT_COMPLETIONS}
* Some types in getters and setters may not be supported properly yet.
*/
public final class CustomChatCompletions extends PacketAccessor {
    public CustomChatCompletions(Object handle) {
        super(PacketType.Play.Server.CUSTOM_CHAT_COMPLETIONS, handle);
    }

    public CustomChatCompletions() {
        super(PacketType.Play.Server.CUSTOM_CHAT_COMPLETIONS);
    }

    public Object getAction() {
        return this.get(0);
    }

    public void setAction(Object value) {
        this.set(0, value);
    }

    public List getEntries() {
        return this.get(1);
    }

    public void setEntries(List value) {
        this.set(1, value);
    }
}
