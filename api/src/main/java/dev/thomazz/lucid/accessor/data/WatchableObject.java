package dev.thomazz.lucid.accessor.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WatchableObject {
    private int type;
    private int id;
    private Object value;
}
