package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;
import org.bukkit.Material;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MaterialConverter extends Converter<Material> {
    private static final Class<?> BLOCKDATA_CLASS = MinecraftReflection.getMinecraftClass(
        "world.level.block.state.IBlockData",
        "world.level.block.state.BlockState",
        "IBlockData"
    );

    private static final Class<?> BLOCK = MinecraftReflection.getMinecraftClass(
        "world.level.block.Block",
        "Block"
    );

    private static final Class<?> CRAFT_MAGIC_NUMBERS_CLASS = MinecraftReflection.getCraftBukkitClass(
        "util.CraftMagicNumbers"
    );

    @Override
    public Material convertFrom(Object handle) throws Exception {
        Method fromBlockData = this.cache("fromBlockData", () -> Reflections.findMethod(MaterialConverter.BLOCKDATA_CLASS,
            method -> !Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 0,
            method -> method.getReturnType().equals(MaterialConverter.BLOCK)
        ));

        Method getMaterial = this.cache("getMaterial", () -> Reflections.findMethod(MaterialConverter.CRAFT_MAGIC_NUMBERS_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 1,
            method -> method.getParameterTypes()[0].equals(MaterialConverter.BLOCK),
            method -> method.getReturnType().equals(Material.class)
        ));

        Object block = fromBlockData.invoke(handle);
        Object material = getMaterial.invoke(handle, block);
        return (Material) material;
    }

    @Override
    public Object convertTo(Material data) throws Exception {
        Method toBlock = this.cache("toBlock", () -> Reflections.findMethod(MaterialConverter.CRAFT_MAGIC_NUMBERS_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 1,
            method -> method.getParameterTypes()[0].equals(Material.class),
            method -> method.getReturnType().equals(MaterialConverter.BLOCK)
        ));

        Method toBlockData = this.cache("toBlockData", () -> Reflections.findMethod(MaterialConverter.BLOCK,
            method -> !Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 0,
            method -> method.getReturnType().equals(MaterialConverter.BLOCKDATA_CLASS)
        ));

        Object block = toBlock.invoke(null, data);
        return toBlockData.invoke(block);
    }
}
