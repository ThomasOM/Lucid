package dev.thomazz.lucid.version;

import lombok.Data;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class MinecraftVersion {
    private static final Pattern PATTERN = Pattern.compile("([1-9])\\w+");

    public static final MinecraftVersion V1_8 = new MinecraftVersion(1, 8);
    public static final MinecraftVersion V1_12 = new MinecraftVersion(1, 12);
    public static final MinecraftVersion V1_14 = new MinecraftVersion(1, 14);
    public static final MinecraftVersion V1_16 = new MinecraftVersion(1, 16);
    public static final MinecraftVersion V1_17 = new MinecraftVersion(1, 17);
    public static final MinecraftVersion V1_18 = new MinecraftVersion(1, 18);
    public static final MinecraftVersion V1_19 = new MinecraftVersion(1, 19);

    private static MinecraftVersion CURRENT;

    private final int majorVersion;
    private final int minorVersion;

    /**
     * If the checked version is equal or above this version.
     */
    public boolean equalsOrAbove(MinecraftVersion version) {
        if (this.majorVersion > version.majorVersion) {
            return true;
        }

        return this.majorVersion == version.majorVersion && this.minorVersion >= version.minorVersion;
    }

    /**
     * If the checked version is equal or above this version.
     */
    public boolean equalsOrBelow(MinecraftVersion version) {
        if (this.majorVersion < version.majorVersion) {
            return true;
        }

        return this.majorVersion == version.majorVersion && this.minorVersion <= version.minorVersion;
    }

    @Override
    public String toString() {
        return this.majorVersion + "." + this.minorVersion;
    }

    public static void init(JavaPlugin plugin) {
        MinecraftVersion.CURRENT = MinecraftVersion.parseVersion(plugin);
    }

    public static MinecraftVersion current() {
        return MinecraftVersion.CURRENT;
    }

    public static MinecraftVersion fromString(String string) {
        String[] split = string.split("\\.");
        int majorVersion = Integer.parseInt(split[0]);
        int minorVersion = Integer.parseInt(split[1]);
        return new MinecraftVersion(majorVersion, minorVersion);
    }

    private static MinecraftVersion parseVersion(JavaPlugin plugin) {
        String packageName = plugin.getServer().getClass().getPackage().getName();
        Matcher matcher = MinecraftVersion.PATTERN.matcher(packageName);
        if (matcher.find()) {
            String match = matcher.group();
            String[] split = match.split(match);
            int major = Integer.parseInt(split[0]);
            int minor = Integer.parseInt(split[1]);
            return new MinecraftVersion(major, minor);
        } else {
            throw new RuntimeException("Could not find craftbukkit version!");
        }
    }
}
