package org.example.factory;

import org.example.entities.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemFactoryTest {

    @Test
    public void create() {
        var actualItem = new ItemFactory().create("item");
        assertTrue(actualItem instanceof Item);

        var actualNull = new ItemFactory().create("");
        assertNull(actualNull);
    }
}