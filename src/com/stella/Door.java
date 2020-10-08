package com.stella;

import java.util.concurrent.TimeUnit;

public class Door {
    private boolean isOpen;

    // Door class constructor
    public Door() {
        this.isOpen = false;
    }

    // check whether door is open
    public boolean isOpen() {
        return this.isOpen;
    }

    // open or close door by passing true or false
    private void setOpen(boolean open) {
        isOpen = open;
    }

    // open elevator door
    public void open () throws InterruptedException {
        System.out.println("Door opening . . .");
        // waiting for elevator for 3 seconds
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Elevator Door open");
        setOpen(true);
    }

    // close elevator door
    public void close () {
        System.out.println("Door Closed");
        System.out.println("Elevator can now restart.");
        setOpen(false);
    }

}