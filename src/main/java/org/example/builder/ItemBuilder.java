package org.example.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.IItem;
import org.example.entities.Item;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemBuilder {
    public static void fromFile(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.readValue(Paths.get(fileName).toFile(), Item.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<IItem> itemsFromDirectory() {
        ArrayList<IItem> items = new ArrayList<>();

        File directory = new File("data/");

        File[] directoryFiles = directory.listFiles();

        assert directoryFiles != null;

        Arrays.stream(directoryFiles)
                .forEach(item -> fromFile(item.getPath()));

        return items;
    }
}
