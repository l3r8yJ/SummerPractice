package org.example.services;

import org.example.entities.IItem;
import org.example.exception.NullItemException;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * The type Item validation service validate encapsulated items
 * and validate every single item.
 */
public class ItemValidationService extends ItemService {

    public ItemValidationService(ArrayList<IItem> items) {
        super(items);
        validateItems();
    }


    private void validateItems() {
        if (items.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format("{0} is empty!", items));
        }

        items.forEach(this::validateItem);
    }


    protected void validateItem(IItem item) {
        if (item == null) {
            throw new NullItemException();
        }
    }
}
