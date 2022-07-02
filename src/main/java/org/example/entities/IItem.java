package org.example.entities;

public interface IItem {
    /**
     * Represents object into JSON
     */
    void toJson();

    boolean isExpired();

}
