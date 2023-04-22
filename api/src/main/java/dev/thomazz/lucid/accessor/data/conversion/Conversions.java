package dev.thomazz.lucid.accessor.data.conversion;

import dev.thomazz.lucid.accessor.data.BlockPosition;
import dev.thomazz.lucid.accessor.data.ChunkCoord;
import dev.thomazz.lucid.accessor.data.MultiBlockChangeInfo;
import dev.thomazz.lucid.accessor.data.SectionPosition;
import dev.thomazz.lucid.accessor.data.conversion.converters.BlockDataConverter;
import dev.thomazz.lucid.accessor.data.conversion.converters.BlockPositionConverter;
import dev.thomazz.lucid.accessor.data.conversion.converters.ChunkCoordConverter;
import dev.thomazz.lucid.accessor.data.conversion.converters.MultiBlockChangeInfoConverter;
import dev.thomazz.lucid.accessor.data.conversion.converters.PotionEffectTypeConverter;
import dev.thomazz.lucid.accessor.data.conversion.converters.SectionPositionConverter;
import lombok.experimental.UtilityClass;
import org.bukkit.block.data.BlockData;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class Conversions {
    private final Map<Class<?>, Converter<?>> CONVERTER_MAP = new HashMap<>();

    static {
        Conversions.register(BlockData.class, new BlockDataConverter());
        Conversions.register(BlockPosition.class, new BlockPositionConverter());
        Conversions.register(ChunkCoord.class, new ChunkCoordConverter());
        Conversions.register(SectionPosition.class, new SectionPositionConverter());
        Conversions.register(MultiBlockChangeInfo.class, new MultiBlockChangeInfoConverter());
        Conversions.register(PotionEffectType.class, new PotionEffectTypeConverter());
    }

    private <T> void register(Class<T> clazz, Converter<T> converter) {
        Conversions.CONVERTER_MAP.put(clazz, converter);
    }

    @SuppressWarnings("unchecked")
    public <T> Converter<T> getConverter(Class<T> clazz) {
        return (Converter<T>) Conversions.CONVERTER_MAP.get(clazz);
    }
}