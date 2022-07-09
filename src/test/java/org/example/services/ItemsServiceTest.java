package org.example.services;

import org.example.entities.IItem;
import org.example.entities.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        Item first = new Item();
        setItem(first);
        first.setId(10);
        first.setName("Milk");

        Item second = new Item();
        setItem(second);
        second.setId(20);
        second.setName("Pineapple");

        Item third = new Item();
        setItem(third);
        third.setId(21);
        third.setName("Watermelon");

        ArrayList<IItem> items = new ArrayList<>();

        items.add(first);
        items.add(second);

        ItemsService service = new ItemsService(items);

        var secondAfter = service.items.get(1);
        System.out.println("second after: " + secondAfter);

        service.updateItemById(20, third);

        var secondBefore = service.items.get(1);
        System.out.println("second before: " + secondBefore);

        System.out.println(service.items.size());

        assertNotEquals(secondAfter, secondBefore);

    }
    // new Test's

    @Test
    public void deleteItemById() {
        Item first = new Item();
        setItem(first);
        first.setId(10);
        first.setName("Milk");

        Item second = new Item();
        setItem(second);
        second.setId(20);
        second.setName("Pineapple");

        ArrayList<IItem> items = new ArrayList<>();
        items.add(first);
        items.add(second);

        ItemsService service = new ItemsService(items);

        var sizeAfter = service.items.size();
        System.out.println("Size After: " + sizeAfter);

        service.deleteItemById(20);

        var sizeBefore = service.items.size();
        System.out.println("Size Before: " + sizeBefore);

        assertNotEquals(sizeAfter, sizeBefore);

    }

    @Test
    public void expiredItems() {
        Item first = new Item();
        setItem(first);
        first.setId(10);
        first.setName("Milk");
        first.setManufactureDate(new GregorianCalendar(2022, Calendar.JUNE, 28));

        Item second = new Item();
        setItem(second);
        second.setId(20);
        second.setName("Pineapple");
        second.setManufactureDate(new GregorianCalendar(2022, Calendar.JUNE, 26));
        second.setStoragePeriod(8);

        Item third = new Item();
        setItem(third);
        third.setId(21);
        third.setName("Watermelon");
        third.setManufactureDate(new GregorianCalendar(2022, Calendar.JULY, 4));

        ArrayList<IItem> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);

        ItemsService service = new ItemsService(items);
        ArrayList<IItem> isExpiredItems;

        isExpiredItems = service.expiredItems();
        System.out.println(isExpiredItems);
        System.out.println("Size: " + service.items.size());
        System.out.println("Expired Size: " + service.expiredItems().size());

        assertEquals(2, isExpiredItems.size());


    }

    // I need help :c

    @Test
    public void dumpAllToJson() {
        Item first = new Item();
        setItem(first);
        first.setId(10);
        first.setName("Milk");

        Item second = new Item();
        setItem(second);
        second.setId(11);
        second.setName("Pineapple");

        Item third = new Item();
        setItem(third);
        third.setId(12);
        third.setName("Watermelon");

        ArrayList<IItem> items = new ArrayList<>();
        items.add(first);
        items.add(second);

        ItemsService service = new ItemsService(items);
        service.addItem(third);

        service.saveAllItemsToJson();



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