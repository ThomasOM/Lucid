package dev.thomazz.lucid.accessor.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChunkMap {
    private byte[] data;
    private int mask;
}
