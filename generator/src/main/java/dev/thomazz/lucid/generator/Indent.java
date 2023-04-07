package dev.thomazz.lucid.generator;

import dev.thomazz.lucid.generator.content.ClassContent;
import lombok.RequiredArgsConstructor;

/**
 * Utility for indenting {@link ClassContent}
 */
@RequiredArgsConstructor
public class Indent {
    private int level;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < level; i++) {
            builder.append("    ");
        }

        return builder.toString();
    }

    public void increment() {
        this.level++;
    }

    public void decrement() {
        this.level = Math.max(this.level - 1, 0);
    }
}
