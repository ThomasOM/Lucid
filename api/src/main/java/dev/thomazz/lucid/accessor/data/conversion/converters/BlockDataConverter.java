package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.ReflectionUtil;
import org.bukkit.block.data.BlockData;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BlockDataConverter implements Converter<BlockData> {
    private static final Class<?> BLOCKDATA_CLASS = MinecraftReflection.getMinecraftClass(
        "world.level.block.state.IBlockData",
        "world.level.block.state.BlockState",
        "IBlockData"
    );

    private static Method FROM;
    private static Method TO;

    @Override
    public BlockData fromHandle(Object handle) {
        if (BlockDataConverter.FROM == null) {
            Class<?> bukkitClass = MinecraftReflection.getCraftBukkitClass("block.data.CraftBlockData");
            BlockDataConverter.FROM = ReflectionUtil.findMethod(bukkitClass,
                method -> Modifier.isStatic(method.getModifiers()),
                method -> method.getParameters().length == 1,
                method -> method.getReturnType().equals(handle.getClass())
            );
        }

        return ReflectionUtil.invokeMethod(BlockDataConverter.FROM, null, handle);
    }

    @Override
    public Object toHandle(BlockData data) {
        if (BlockDataConverter.TO == null) {
            Class<?> bukkitClass = MinecraftReflection.getCraftBukkitClass("block.data.CraftBlockData");
            BlockDataConverter.TO = ReflectionUtil.findMethod(bukkitClass,
                method -> !Modifier.isStatic(method.getModifiers()),
                method -> method.getParameters().length == 0,
                method -> method.getReturnType().equals(BlockDataConverter.BLOCKDATA_CLASS)
            );
        }

        return ReflectionUtil.invokeMethod(BlockDataConverter.TO, data);
    }
}
