package dev.thomazz.lucid.generator;

import com.google.common.base.CaseFormat;
import dev.thomazz.lucid.generator.content.ClassContent;
import dev.thomazz.lucid.generator.content.FieldContent;
import dev.thomazz.lucid.generator.content.ImportContent;
import dev.thomazz.lucid.packet.PacketType;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows building class file content with {@link ClassContent} components.
 */
@Getter
public class ClassFile {
    private final List<ImportContent> imports = new ArrayList<>();
    private final List<FieldContent> fields = new ArrayList<>();

    private final PacketType type;
    private final String className;
    private final String packageName;
    private final String reference;

    public ClassFile(PacketType type, String className, String packageName) {
        this.type = type;
        this.className = className;
        this.packageName = packageName;

        String state = StringUtils.capitalize(this.type.getState().name().toLowerCase());
        String source = StringUtils.capitalize(this.type.getSource().name().toLowerCase());
        String convertedName = this.className.replace("NBT", "Nbt");
        String typeName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, convertedName);

        this.reference = "PacketType." + state + "." + source + "." + typeName;
    }


    private void parseJavaDoc(StringBuilder builder, String reference) {
        builder.append("/**")
            .append(System.lineSeparator())
            .append("* Accessor class generated by script for packet type {@link ")
            .append(reference.replaceAll("\\.(?!.*\\.)", "#"))
            .append("}")
            .append(System.lineSeparator())
            .append("* Some types in getters and setters may not be supported properly yet.")
            .append(System.lineSeparator())
            .append("*/")
            .append(System.lineSeparator());
    }

    private void parseConstructor(StringBuilder builder, Indent indent, String reference) {
        builder.append(indent)
            .append("public ")
            .append(this.className)
            .append("(Object handle) {")
            .append(System.lineSeparator());

        indent.increment();

        builder.append(indent)
            .append("super(")
            .append(reference)
            .append(", handle);")
            .append(System.lineSeparator());

        indent.decrement();

        builder.append(indent)
            .append("}")
            .append(System.lineSeparator());
    }

    private void parseHandleConstructor(StringBuilder builder, Indent indent, String reference) {
        builder.append(indent)
            .append("public ")
            .append(this.className)
            .append("() {")
            .append(System.lineSeparator());

        indent.increment();

        builder.append(indent)
            .append("super(")
            .append(reference)
            .append(");")
            .append(System.lineSeparator());

        indent.decrement();

        builder.append(indent)
            .append("}")
            .append(System.lineSeparator());
    }

    public void addImport(ImportContent content) {
        this.imports.add(content);
    }

    public void addField(FieldContent content) {
        this.fields.add(content);
    }

    @Override
    public String toString() {
        Indent indent = new Indent();
        StringBuilder builder = new StringBuilder();

        // Package declaration
        builder.append("package ")
            .append(this.packageName)
            .append(";")
            .append(System.lineSeparator())
            .append(System.lineSeparator());

        // Imports
        this.imports.forEach(i -> i.parse(builder, indent));

        // Javadoc
        builder.append(System.lineSeparator());
        this.parseJavaDoc(builder, this.reference);

        // Class header
        builder.append("public final class ")
            .append(this.className)
            .append(" extends PacketAccessor {");

        indent.increment();

        // Constructors
        builder.append(System.lineSeparator());
        this.parseConstructor(builder, indent, this.reference);
        builder.append(System.lineSeparator());
        this.parseHandleConstructor(builder, indent, this.reference);

        // Getters and setters for fields
        this.fields.forEach(f -> {
            builder.append(System.lineSeparator());
            f.parse(builder, indent);
        });

        // Close file
        builder.append("}");

        return builder.toString();
    }
}
