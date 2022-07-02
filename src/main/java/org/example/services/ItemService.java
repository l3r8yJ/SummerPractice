package org.example.services;

import org.example.entities.IItem;

import java.util.ArrayList;

/**
 * The type Item service does different interactions with list of items.
 */
public class ItemService {
    /**
     * The Items.
     */
    protected final ArrayList<IItem> items;


    public ItemService(ArrayList<IItem> items) {
        this.items = items;
    }
}
