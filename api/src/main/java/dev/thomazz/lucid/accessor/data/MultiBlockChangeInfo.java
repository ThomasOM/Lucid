package dev.thomazz.lucid.accessor.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

@Getter
@Setter
@AllArgsConstructor
public class MultiBlockChangeInfo {
    private short location;
    private Material material;
}
