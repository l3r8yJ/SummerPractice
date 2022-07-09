package org.example.entities;

import org.example.factory.ItemFactory;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void toJson() {
        Item item = (Item) new ItemFactory().create("Item");

        prepareItem(item);

        item.toJson();

        boolean actualFileExist = Files.exists(Paths.get("data/" + item.id + ".json"));

        assertTrue(actualFileExist);
    }


    @Test
    public void isExpired() {
        Calendar dateExpired = new GregorianCalendar(2020, Calendar.NOVEMBER, 15);
        Calendar dateNotExpired = new GregorianCalendar();

        Item expiredItem = new Item();
        Item notExpiredItem = new Item();

        prepareItem(expiredItem);
        prepareItem(notExpiredItem);

        expiredItem.setManufactureDate(dateExpired);
        notExpiredItem.setManufactureDate(dateNotExpired);

        assertTrue(expiredItem.isExpired());
        assertFalse(notExpiredItem.isExpired());
    }


    private void prepareItem(Item item) {
        item.setDeliveryDate(new GregorianCalendar(2020, Calendar.NOVEMBER, 10));
        item.setDeliveryVolume(10);
        item.setId(1);
        item.setName("Apple");
        item.setPackageType("cellophane");
        item.setPrice(1000f);
        item.setSalesVolume(20);
        item.setStoragePeriod(8);
        item.setManufactureDate(new GregorianCalendar(2020, Calendar.NOVEMBER, 8));
    }

    @Test
    public void getPrice() {
        Item testItem = new Item();
        prepareItem(testItem);

        float expectedPrice = 500f;
        float actualPrice = testItem.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.5f);

        testItem.setManufactureDate(new GregorianCalendar());

        expectedPrice = 1000f;
        actualPrice = testItem.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.5f);
    }
}