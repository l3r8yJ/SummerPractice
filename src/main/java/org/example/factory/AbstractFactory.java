package org.example.factory;

public interface AbstractFactory<T> {
    T create(String itemType);
}
