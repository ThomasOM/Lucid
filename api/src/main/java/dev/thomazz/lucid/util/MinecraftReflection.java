package dev.thomazz.lucid.util;

import java.lang.reflect.Field;
import java.util.Arrays;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public class MinecraftReflection {
    public Object getServerConnection() throws Exception {
        Object minecraftServer = Bukkit.getServer().getClass().getDeclaredMethod("getServer").invoke(Bukkit.getServer());
        Field connectionField = ReflectionUtil.getFieldByClassNames(minecraftServer.getClass().getSuperclass(), "ServerConnection");
        return connectionField.get(minecraftServer);
    }

    public Class<?> getCraftBukkitClass(String... names) {
        String packageName = MinecraftReflection.getCraftBukkitPackage();
        for(String name : names) {
            try {
                return Class.forName(packageName + "." + name);
            } catch (Throwable ignored) {
            }
        }

        throw new RuntimeException("Could not find minecraft class: " + Arrays.toString(names));
    }

    public Class<?> getMinecraftClass(String... names) {
        String[] packageNames = new String[] {
            MinecraftReflection.getMinecraftPackage(),
            MinecraftReflection.getMinecraftPackageLegacy()
        };

        for (String packageName : packageNames) {
            for(String name : names) {
                try {
                    return Class.forName(packageName + "." + name);
                } catch (Throwable ignored) {
                }
            }
        }

        throw new RuntimeException("Could not find minecraft class: " + Arrays.toString(names));
    }

    public String getCraftBukkitPackage() {
        return Bukkit.getServer().getClass().getPackage().getName();
    }

    public String getMinecraftPackage() {
        return "net.minecraft";
    }

    public String getMinecraftPackageLegacy() {
        return MinecraftReflection.getCraftBukkitPackage()
            .replace("org.bukkit.craftbukkit", "net.minecraft.server");
    }
}
