package org.example.builder;

import org.example.entities.IItem;
import org.junit.Test;

import java.util.ArrayList;

public class ItemBuilderTest {

    @Test
    public void itemsFromDirectory() {
        ArrayList<IItem> items = ItemBuilder.itemsFromDirectory();

        items.forEach(System.out::println);
    }
}