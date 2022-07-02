package org.example.services;

import org.example.entities.IItem;

import java.util.ArrayList;

/**
 * The type Item dump service dumps encapsulated items into json files.
 */
public class ItemDumpService extends ItemValidationService {

    public ItemDumpService(ArrayList<IItem> items) {
        super(items);
    }


    public void dumpAllToJson() {
        items.forEach(IItem::toJson);
    }
}
