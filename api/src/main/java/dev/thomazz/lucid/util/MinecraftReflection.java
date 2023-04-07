package dev.thomazz.lucid.util;

import java.lang.reflect.Field;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public class MinecraftReflection {
    public Object getServerConnection() throws Exception {
        Object minecraftServer = Bukkit.getServer().getClass().getDeclaredMethod("getServer").invoke(Bukkit.getServer());
        Field connectionField = ReflectionUtil.getFieldByClassNames(minecraftServer.getClass().getSuperclass(), "ServerConnection");
        return connectionField.get(minecraftServer);
    }
}
