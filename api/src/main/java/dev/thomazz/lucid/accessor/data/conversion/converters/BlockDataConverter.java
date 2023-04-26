package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;
import org.bukkit.block.data.BlockData;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BlockDataConverter extends Converter<BlockData> {
    private static final Class<?> BLOCKDATA_CLASS = MinecraftReflection.getMinecraftClass(
        "world.level.block.state.IBlockData",
        "world.level.block.state.BlockState",
        "IBlockData"
    );

    private static final Class<?> CRAFT_BLOCK_DATA_CLASS = MinecraftReflection.getCraftBukkitClass(
        "block.data.CraftBlockData"
    );

    @Override
    public BlockData convertFrom(Object handle) throws Exception {
        Method from = this.cache("from", () -> Reflections.findMethod(BlockDataConverter.CRAFT_BLOCK_DATA_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 1,
            method -> method.getReturnType().equals(BlockDataConverter.CRAFT_BLOCK_DATA_CLASS)
        ));

        return (BlockData) from.invoke(null, handle);
    }

    @Override
    public Object convertTo(BlockData data) throws Exception {
        Method to = this.cache("to", () -> Reflections.findMethod(BlockDataConverter.CRAFT_BLOCK_DATA_CLASS,
            method -> !Modifier.isStatic(method.getModifiers()),
            method -> method.getParameterCount() == 0,
            method -> method.getReturnType().equals(BlockDataConverter.BLOCKDATA_CLASS)
        ));

        return to.invoke(data);
    }
}
