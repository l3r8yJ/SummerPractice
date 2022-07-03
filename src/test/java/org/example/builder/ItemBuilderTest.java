package org.example.builder;

import org.example.entities.IItem;
import org.example.entities.Item;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ItemBuilderTest {

    private void setItem(Item item) {
        item.setDeliveryDate(new Date(2020, Calendar.NOVEMBER, 10));
        item.setDeliveryVolume(10);
        item.setId(1);
        item.setName("Apple");
        item.setPackageType("cellophane");
        item.setPrice(80.99f);
        item.setSalesVolume(20);
        item.setStoragePeriod(30);
    }

    @Test
    public void itemsFromDirectory() {
        ArrayList<IItem> items = ItemBuilder.itemsFromDirectory();

        items.forEach(System.out::println);
    }
}