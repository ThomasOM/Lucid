package dev.thomazz.lucid.generator.content;

import dev.thomazz.lucid.generator.ClassFile;
import dev.thomazz.lucid.generator.Indent;

/**
 * Defines content that can be parsed for a {@link ClassFile}
 */
public interface ClassContent {
    void parse(StringBuilder builder, Indent indent);
}
