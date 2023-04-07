package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import java.util.List;
import java.util.List;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#RECIPES}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Recipes extends PacketAccessor {
    public Recipes(Object handle) {
        super(PacketType.Play.Server.RECIPES, handle);
    }

    public Recipes() {
        super(PacketType.Play.Server.RECIPES);
    }

    public Object getState() {
        return this.get(0);
    }

    public void setState(Object value) {
        this.set(0, value);
    }

    public List getRecipes() {
        return this.get(1);
    }

    public void setRecipes(List value) {
        this.set(1, value);
    }

    public List getToHighlight() {
        return this.get(2);
    }

    public void setToHighlight(List value) {
        this.set(2, value);
    }

    public Object getBookSettings() {
        return this.get(3);
    }

    public void setBookSettings(Object value) {
        this.set(3, value);
    }
}