package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ItemStackConverter extends Converter<ItemStack> {
    private static final Class<?> CRAFT_ITEM_STACK_CLASS = MinecraftReflection.getCraftBukkitClass(
        "inventory.CraftItemStack"
    );

    @Override
    protected ItemStack convertFrom(Object handle) throws Exception {
        Method from = this.cache("from", () -> Reflections.findMethod(ItemStackConverter.CRAFT_ITEM_STACK_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 1,
            method -> ItemStack.class.equals(method.getReturnType())
        ));

        return (ItemStack) from.invoke(null, handle);
    }

    @Override
    protected Object convertTo(ItemStack object) throws Exception {
        Method to = this.cache("to", () -> Reflections.findMethod(ItemStackConverter.CRAFT_ITEM_STACK_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 1,
            method -> ItemStack.class.equals(method.getParameterTypes()[0])
        ));

        return to.invoke(null, object);
    }
}
