package dev.thomazz.lucid.generator.content;

import dev.thomazz.lucid.generator.Indent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImportContent implements ClassContent {
    private final Class<?> type;

    @Override
    public void parse(StringBuilder builder, Indent indent) {
        builder.append("import ").append(this.type.getName()).append(";").append(System.lineSeparator());
    }
}
