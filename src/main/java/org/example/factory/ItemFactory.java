package org.example.factory;

import org.example.entities.IItem;
import org.example.entities.Item;

public class ItemFactory implements AbstractFactory<IItem> {
    @Override
    public IItem create(String itemType) {
        if ("Item".equalsIgnoreCase(itemType)) {
            return new Item();
        }

        return null;
    }
}
