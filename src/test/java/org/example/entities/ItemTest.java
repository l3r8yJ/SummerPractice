package org.example.entities;

import org.example.factory.ItemFactory;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTest {

    @Test
    public void toJson() {
        Item item = (Item) new ItemFactory().create("Item");

        setItem(item);

        item.toJson();

        boolean actualFileExist = Files.exists(Paths.get("data/" + item.id + ".json"));

        assertTrue(actualFileExist);
    }


    @Test
    public void isExpired() {
        Calendar dateExpired = new GregorianCalendar(2020, Calendar.NOVEMBER, 15);
        Calendar dateNotExpired = new GregorianCalendar(2022, Calendar.JUNE, 30);

        Item expiredItem = new Item();
        Item notExpiredItem = new Item();

        setItem(expiredItem);
        setItem(notExpiredItem);

        expiredItem.setManufactureDate(dateExpired);
        notExpiredItem.setManufactureDate(dateNotExpired);

        assertTrue(expiredItem.isExpired());
        assertFalse(notExpiredItem.isExpired());

    }


    private void setItem(Item item) {
        item.setDeliveryDate(new GregorianCalendar(2020, Calendar.NOVEMBER, 10));
        item.setDeliveryVolume(10);
        item.setId(1);
        item.setName("Apple");
        item.setPackageType("cellophane");
        item.setPrice(80.99f);
        item.setSalesVolume(20);
        item.setStoragePeriod(5);
        item.setManufactureDate(new GregorianCalendar(2020, Calendar.NOVEMBER, 8));
    }

}