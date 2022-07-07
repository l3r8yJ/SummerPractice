package org.example.services;

import org.example.entities.IItem;
import org.example.exception.NullItemException;

import java.util.ArrayList;

public class ItemsService extends ItemValidationService {
    public ItemsService(ArrayList<IItem> items) {
        super(items);
    }


    public void addItem(IItem item) {
        validate(item);

        items.add(item);
    }


    public void updateItemById(int id, IItem updatedItem) {
        for (IItem item : items) {
            if (item.getId() == id) {
                item = updatedItem;
                return;
            }
        }
    }


    public void deleteItemById(int id) {
        for (IItem item : items) {
            if (item.getId() == id) {
                items.remove(item);
            }
        }
    }


    public ArrayList<IItem> expiredItems() {
        ArrayList<IItem> expiredItems = new ArrayList<>();

        collectExpiredItems(expiredItems);

        return expiredItems;
    }


    public void dumpAllToJson() {
        for (IItem item : items) {
            item.toJson();
        }
    }


    private void collectExpiredItems(ArrayList<IItem> expiredItems) {
        for (IItem item : items) {
            if (item.isExpired()) {
                expiredItems.add(item);
            }
        }
    }


    private void validate(IItem item) {
        if (!isValidItem(item)) {
            throw new NullItemException();
        }
    }

    public int getItemsSize(){
        return items.size();
    }


    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @apiNote In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * The string output is not necessarily stable over time or across
     * JVM invocations.
     * @implSpec The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     */
    @Override
    public String toString() {
        return items.toString();
    }
}
