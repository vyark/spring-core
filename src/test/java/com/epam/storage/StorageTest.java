package com.epam.storage;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StorageTest {

    private Storage storage = new Storage();

    @Test
    public void test() {
        storage.initialize();

        assertEquals(22, storage.getRepository().size());
    }
}
