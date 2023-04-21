package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.ReflectionUtil;
import dev.thomazz.lucid.version.MinecraftVersion;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PotionEffectTypeConverter implements Converter<PotionEffectType> {
    private static final Class<?> MOB_EFFECT_LIST_CLASS = MinecraftReflection.getMinecraftClass(
        "world.effect.MobEffectList",
        "MobEffectList"
    );

    private static Constructor<?> CONSTRUCTOR;
    private static Method FROM_ID;

    @Override
    @SuppressWarnings("deprecation")
    public PotionEffectType fromHandle(Object handle) {
        if (MinecraftVersion.current().equalsOrBelow(MinecraftVersion.V1_18)) {
            return PotionEffectType.getById((Integer) handle);
        }

        if (PotionEffectTypeConverter.CONSTRUCTOR == null) {
            Class<?> bukkitClass = MinecraftReflection.getCraftBukkitClass("potion.CraftPotionEffectType");
            PotionEffectTypeConverter.CONSTRUCTOR = ReflectionUtil.findConstructor(bukkitClass,
                constructor -> constructor.getParameters().length == 1,
                constructor -> constructor.getParameterTypes()[0].equals(PotionEffectTypeConverter.MOB_EFFECT_LIST_CLASS)
            );
        }

        return ReflectionUtil.invokeConstructor(PotionEffectTypeConverter.CONSTRUCTOR, handle);
    }

    @Override
    @SuppressWarnings("deprecation")
    public Object toHandle(PotionEffectType object) {
        if (MinecraftVersion.current().equalsOrBelow(MinecraftVersion.V1_18)) {
            return object.getId();
        }

        if (PotionEffectTypeConverter.FROM_ID == null) {
            Class<?> bukkitClass = MinecraftReflection.getCraftBukkitClass("potion.CraftPotionEffectType");
            PotionEffectTypeConverter.FROM_ID = ReflectionUtil.findMethod(bukkitClass,
                method -> Modifier.isStatic(method.getModifiers()),
                method -> method.getParameters().length == 1,
                method -> method.getParameterTypes()[0].equals(int.class),
                method -> method.getReturnType().equals(PotionEffectTypeConverter.MOB_EFFECT_LIST_CLASS)
            );
        }

        return ReflectionUtil.invokeMethod(PotionEffectTypeConverter.FROM_ID, object.getId());
    }
}
