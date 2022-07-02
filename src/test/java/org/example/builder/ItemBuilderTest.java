package org.example.builder;

import org.example.entities.Item;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ItemBuilderTest {

    @Test
    public void fromFile() {
        Item configuredItem = new Item();
        setItem(configuredItem);
        configuredItem.toJson();

        Item itemFromFile = new ItemBuilder()
                .fromFile(
                        String.valueOf(configuredItem.getId()).concat(".json")
                );

        System.out.print(itemFromFile);

        final String expected = configuredItem.toString();
        final String actual = itemFromFile.toString();

        assertEquals(expected, actual);
    }

    private void setItem(Item item) {
        item.setDeliveryDate(new Date(2020, Calendar.NOVEMBER, 10));
        item.setDeliveryVolume(10);
        item.setId(0);
        item.setName("Bread");
        item.setPackageType("cellophane");
        item.setPrice(45.99f);
        item.setSalesVolume(50);
        item.setStoragePeriod(14);
    }
}