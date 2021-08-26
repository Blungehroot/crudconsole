package com.crudconsole.app.helpers;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileHelpers {
    private static final String directory = System.getProperty("user.dir");

    public static String getPathToFile(String fileName) {
        return directory + "/src/main/resources/" + fileName;
    }

    public static void WriteInFile(String data, String fileName) {
        try {
            File file = new File(getPathToFile(fileName));
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(getPathToFile(fileName)); OutputStreamWriter oos = new OutputStreamWriter(fos, StandardCharsets.UTF_8)){
            oos.write(data);
            System.out.println("New data is added");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
