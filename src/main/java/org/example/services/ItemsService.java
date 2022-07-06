package org.example.services;

import lombok.NonNull;
import org.example.entities.IItem;
import org.example.exception.NullItemException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class ItemsService extends ItemValidationService {
    public ItemsService(ArrayList<IItem> items) {
        super(items);
    }


    public void addItem(@NonNull IItem item) {
        items.add(item);
    }


    public void updateItemById(int id, IItem updatedItem) {
        items.stream()
                .filter(item -> Objects.equals(id, item.getId()))
                .forEach(item -> item = updatedItem);
    }


    public void deleteItemById(int id) {
        items.removeIf(item -> item.getId() == id);
    }


    public ArrayList<IItem> expiredItems() {
        return (ArrayList<IItem>) items
                .stream()
                .filter(IItem::isExpired)
                .collect(Collectors.toList());
    }


    public void AllToJson() {
        items.forEach(IItem::toJson);
    }


    private void validate(IItem item) {
        if (!isValidItem(item)) {
            throw new NullItemException();
        }
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
