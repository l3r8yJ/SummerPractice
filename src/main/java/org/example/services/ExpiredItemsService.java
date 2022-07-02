package org.example.services;

import org.example.entities.IItem;
import java.util.ArrayList;


public class ExpiredItemsService extends ItemValidationService {

    public ExpiredItemsService(ArrayList<IItem> items) {
        super(items);
    }


    public ArrayList<IItem> expiredItems() {
        ArrayList<IItem> expiredItems = new ArrayList<>();

        for (IItem item : items) {
            if (item.isExpired()) {
                expiredItems.add(item);
            }
        }

        return expiredItems;
    }
}
