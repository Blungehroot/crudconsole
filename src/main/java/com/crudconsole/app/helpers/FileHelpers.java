package com.crudconsole.app.helpers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHelpers {
    private static final String TARGET_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/";

    //write data in file
    public static void WriteInFile(String data, String fileName) {
        if (Files.exists(Path.of(TARGET_DIRECTORY + fileName))) {
            try (FileOutputStream fos = new FileOutputStream(TARGET_DIRECTORY + fileName);
                 OutputStreamWriter oos = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                oos.write(data);
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            }
        } else {
            createFile(fileName);
            try (FileOutputStream fos = new FileOutputStream(TARGET_DIRECTORY + fileName);
                 OutputStreamWriter oos = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                oos.write(data);
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            }
        }
    }

    //read data from file
    public static String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        if (Files.exists(Path.of(TARGET_DIRECTORY + fileName))) {
            try (Stream<String> stream = Files.lines(Paths.get(TARGET_DIRECTORY + fileName), StandardCharsets.UTF_8)) {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            createFile(fileName);
            try (Stream<String> stream = Files.lines(Paths.get(TARGET_DIRECTORY + fileName), StandardCharsets.UTF_8)) {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contentBuilder.toString();
    }

    //create file
    public static void createFile(String fileName) {
        try {
            File file = new File(TARGET_DIRECTORY + fileName);
            file.createNewFile();
            System.out.println("File created: " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
