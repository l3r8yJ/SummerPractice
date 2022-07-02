package org.example.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.IItem;
import org.example.entities.Item;

import java.io.IOException;
import java.nio.file.Paths;

public class ItemBuilder {
    public Item fromFile(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    Paths.get("data/".concat(fileName)).toFile(),
                    Item.class
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
