package org.example.entities;

import org.example.factory.ItemFactory;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void toJson() {
        Item item = (Item) new ItemFactory().create("Item");

        setItem(item);

        item.toJson();

        boolean actualFileExist = Files.exists(Paths.get("data/" + item.id + ".json"));

        assertTrue(actualFileExist);
    }

    private void setItem(Item item) {
        item.setDeliveryDate(new Date());
        item.setDeliveryVolume(10);
        item.setId(0);
        item.setName("Bread");
        item.setPackageType("cellophane");
        item.setPrice(45.99f);
        item.setSalesVolume(50);
        item.setStoragePeriod(14);
    }

    @Test
    public void isExpired() {
    }
}