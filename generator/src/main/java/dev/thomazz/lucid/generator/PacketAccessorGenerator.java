package dev.thomazz.lucid.generator;

import com.google.common.base.Charsets;
import dev.thomazz.lucid.generator.content.ImportContent;
import dev.thomazz.lucid.generator.content.FieldContent;
import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketIterable;
import dev.thomazz.lucid.packet.PacketType;
import dev.thomazz.lucid.generator.util.TypeUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Script that generates {@link PacketAccessor} extensions for all {@link PacketType} instances.
 * Some return types for packets are not supported because they are not visible to the API.
 * Wrapper objects can be created for these cases or a simple {@link Object} type can be returned.
 */
public class PacketAccessorGenerator {
    public static void main(String[] args) throws Exception {
        File outputDir = new File("output");
        FileUtils.deleteDirectory(outputDir);
        if (!outputDir.mkdir()) {
            throw new RuntimeException("Could not create new output directory!");
        }

        List<URL> urls = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get("libraries"))) {
            walk.map(Path::toFile)
                .filter(file -> file.getName().endsWith(".jar"))
                .forEach(file -> urls.add(PacketAccessorGenerator.parseLibrary(file)));
        }

        System.out.println("Loaded " + urls.size() + " libraries!");
        System.out.println(System.lineSeparator());

        StringBuilder registry = new StringBuilder();

        try (URLClassLoader loader = new URLClassLoader(
            urls.toArray(new URL[]{}),
            PacketAccessorGenerator.class.getClassLoader()
        )) {
            PacketType.iterables().stream()
                .flatMap(PacketIterable::stream)
                .map(type -> PacketAccessorGenerator.createClassFile(loader, type))
                .filter(Optional::isPresent)
                .forEach(result -> PacketAccessorGenerator.exportClassFile(registry, outputDir, result.get()));
        }

        System.out.println(System.lineSeparator());
        System.out.println("Registry: " + registry);
    }

    private static URL parseLibrary(File file) {
        System.out.println("Loading library: " + file.getName());

        try {
            return file.toURI().toURL();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Optional<ClassFile> createClassFile(ClassLoader loader, PacketType type) {
        Class<?> clazz = PacketType.getPacketClass(loader, type.getState(), type.getSource(), type.getNames());
        if (clazz == null) {
            String sep = System.lineSeparator();
            System.out.println(sep + "XXXXXXX - Found no class for type: " + type.getName() + sep);
            return Optional.empty();
        }

        System.out.println("Creating class file for type: " + type.getName());

        // We don't want to include the nested parent name
        String className = type.getName();
        if (className.contains("$")) {
            String[] names = className.split("\\$");
            className = names[names.length - 1];
        }

        // Package name depends on type source and state
        String packagePrefix = "dev.thomazz.lucid.accessor";
        String packageName = packagePrefix + "." + type.getSource().name().toLowerCase() + "."
            + type.getState().name().toLowerCase();

        ClassFile classFile = new ClassFile(type, className, packageName);

        // These classes will always be imported
        classFile.addImport(new ImportContent(PacketAccessor.class));
        classFile.addImport(new ImportContent(PacketType.class));

        // Collect all fields
        List<Field> declared = new ArrayList<>();
        Class<?> scan = clazz;
        while (scan != null && !Object.class.equals(scan)) {
            declared.addAll(Arrays.asList(scan.getDeclaredFields()));
            scan = scan.getSuperclass();
        }

        for (int i = 0; i < declared.size(); i++) {
            Field field = declared.get(i);

            // Ignore static fields
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            // Check type importing
            Class<?> newType = TypeUtils.compatibleType(field.getType());
            if (TypeUtils.needsImport(newType)) {
                classFile.addImport(new ImportContent(field.getType()));
            }

            classFile.addField(new FieldContent(field.getName(), newType, i));
        }

        return Optional.of(classFile);
    }

    private static void exportClassFile(StringBuilder registry, File folder, ClassFile classFile) {
        try {
            // Create folder tree for accessor
            File innerFolder = new File(folder, classFile.getPackageName().replace(".", "/"));
            if (innerFolder.mkdirs()) {
                System.out.println("Created folder: " + innerFolder.getName());
            }

            // Write to file
            File file = new File(innerFolder, classFile.getClassName() + ".java");
            Files.write(file.toPath(), Collections.singletonList(classFile.toString()), Charsets.UTF_8);
            System.out.println("Saved file: " + classFile.getClassName());

            // Add to registry result
            registry.append("register(")
                .append(classFile.getReference())
                .append(", ")
                .append(classFile.getPackageName())
                .append(".")
                .append(classFile.getClassName())
                .append(".class);")
                .append(System.lineSeparator());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}