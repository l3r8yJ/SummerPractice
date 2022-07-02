package org.example.entities;

public interface IItem {
    /**
     * Represents an object into JSON
     */
    void toJson();

    boolean isExpired();

}
