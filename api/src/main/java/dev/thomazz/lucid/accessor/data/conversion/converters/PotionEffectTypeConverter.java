package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;
import dev.thomazz.lucid.version.MinecraftVersion;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PotionEffectTypeConverter extends Converter<PotionEffectType> {
    private static final Class<?> MOB_EFFECT_LIST_CLASS = MinecraftReflection.getMinecraftClass(
        "world.effect.MobEffectList",
        "MobEffectList"
    );

    private static final Class<?> CRAFT_POTION_EFFECT_TYPE_CLASS = MinecraftReflection.getCraftBukkitClass(
        "potion.CraftPotionEffectType"
    );

    @Override
    @SuppressWarnings("deprecation")
    public PotionEffectType convertFrom(Object handle) throws Exception {
        if (MinecraftVersion.current().equalsOrBelow(MinecraftVersion.V1_18)) {
            return PotionEffectType.getById((Integer) handle);
        }

        Constructor<?> init = this.cache("init", () -> Reflections.findConstructor(
            PotionEffectTypeConverter.CRAFT_POTION_EFFECT_TYPE_CLASS,
            constructor -> constructor.getParameters().length == 1,
            constructor -> constructor.getParameterTypes()[0].equals(PotionEffectTypeConverter.MOB_EFFECT_LIST_CLASS)
        ));

        return (PotionEffectType) init.newInstance(handle);
    }

    @Override
    @SuppressWarnings("deprecation")
    public Object convertTo(PotionEffectType object) throws Exception {
        if (MinecraftVersion.current().equalsOrBelow(MinecraftVersion.V1_18)) {
            return object.getId();
        }

        Method fromId = this.cache("from", () -> Reflections.findMethod(
            PotionEffectTypeConverter.CRAFT_POTION_EFFECT_TYPE_CLASS,
            method -> Modifier.isStatic(method.getModifiers()),
            method -> method.getParameters().length == 1,
            method -> method.getParameterTypes()[0].equals(int.class),
            method -> method.getReturnType().equals(PotionEffectTypeConverter.MOB_EFFECT_LIST_CLASS)
        ));

        return fromId.invoke(null, object.getId());
    }
}
