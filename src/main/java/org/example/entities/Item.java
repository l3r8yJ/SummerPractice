package org.example.entities;


public class Item implements IItem {
    /**
     * Represents an object into JSON
     */
    @Override
    public void toJson() {

    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
