package dev.thomazz.lucid.generator.content;

import com.google.common.base.CaseFormat;
import dev.thomazz.lucid.generator.Indent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FieldContent implements ClassContent {
    private final String name;
    private final Class<?> type;
    private final int index;

    @Override
    public void parse(StringBuilder builder, Indent indent) {
        this.buildGetter(builder, indent);
        builder.append(System.lineSeparator());
        this.buildSetter(builder, indent);
    }

    private void buildGetter(StringBuilder builder, Indent indent) {
        builder.append(indent)
            .append("public ")
            .append(this.type.getSimpleName())
            .append(" get")
            .append(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, this.name))
            .append("() {")
            .append(System.lineSeparator());

        indent.increment();

        builder.append(indent).append("return this.get(")
            .append(this.index)
            .append(");")
            .append(System.lineSeparator());

        indent.decrement();

        builder.append(indent)
            .append("}")
            .append(System.lineSeparator());
    }

    private void buildSetter(StringBuilder builder, Indent indent) {
        builder.append(indent)
            .append("public void set")
            .append(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, this.name))
            .append("(")
            .append(this.type.getSimpleName())
            .append(" value")
            .append(") {")
            .append(System.lineSeparator());

        indent.increment();

        builder.append(indent).append("this.set(")
            .append(this.index)
            .append(", value")
            .append(");")
            .append(System.lineSeparator());

        indent.decrement();

        builder.append(indent)
            .append("}")
            .append(System.lineSeparator());
    }
}
