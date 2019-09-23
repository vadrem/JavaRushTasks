package com.javarush.task.task33.task3310.strategy;

public interface StorageStrategy {
    boolean containsKey(final Long key);

    boolean containsValue(final String value);

    void put(final Long key, final String value);

    Long getKey(final String value);

    String getValue(final Long key);
}
