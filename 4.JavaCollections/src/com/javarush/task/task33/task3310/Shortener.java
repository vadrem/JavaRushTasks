package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {

    private Long lastId = 0L;
    private final StorageStrategy storageStrategy;

    public Shortener(final StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(final String string)
    {
        Long id = this.storageStrategy.getKey(string);
        if (id == null)
        {
            this.lastId++;
            this.storageStrategy.put(this.lastId, string);
            return this.lastId;
        }

        return id;
    }

    public synchronized String getString(final Long id)
    {
        return this.storageStrategy.getValue(id);
    }
}
