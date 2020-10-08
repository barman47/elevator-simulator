package com.stella;

import org.junit.Assert;
import org.junit.Test;

public class DoorTest {

    Door door = new Door();

    @Test
    public void isOpen() {
        boolean actual = false;
        boolean expected = door.isOpen();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);

    }

    @Test
    public void open() throws InterruptedException {
        door.open();
        boolean actual = door.isOpen();
        boolean expected = true;
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void close() {
        boolean actual = door.isOpen();
        boolean expected = false;
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }
}