package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.IItem;
import org.example.entities.Item;
import org.example.factory.ItemFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Item item = (Item) new ItemFactory().create("Item");

        item.setDeliveryDate(new Date());
        item.setDeliveryVolume(10);
        item.setId(0);
        item.setName("Bread");
        item.setPackageType("cellophane");
        item.setPrice(45.99f);
        item.setSalesVolume(50);
        item.setStoragePeriod(14);
        item.toJson();
    }
}