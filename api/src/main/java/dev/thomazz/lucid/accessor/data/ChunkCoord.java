package dev.thomazz.lucid.accessor.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChunkCoord {
    private final int x;
    private final int z;
}
