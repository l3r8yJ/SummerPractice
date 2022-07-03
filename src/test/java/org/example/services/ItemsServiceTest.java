package org.example.services;

import org.example.entities.IItem;
import org.example.entities.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsServiceTest {

    @Test
    public void addItem() {

        Item first = new Item();
        setItem(first);

        Item second = new Item();
        setItem(second);
        second.setId(2);

        ArrayList<IItem> items = new ArrayList<>();
        items.add(first);

        ItemsService service = new ItemsService(items);
        var lengthBefore = service.items.size();
        System.out.println("service before = " + service);

        service.addItem(second);
        var lengthAfter = service.items.size();
        System.out.println("service after = " + service);

        assertEquals(lengthBefore + 1, lengthAfter);

    }

    @Test
    public void updateItemById() {
    }

    @Test
    public void deleteItemById() {
    }

    @Test
    public void expiredItems() {
    }

    @Test
    public void dumpAllToJson() {
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