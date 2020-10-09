package com.stella;

import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class ElevatorTest {
    private int floor = 1;
    private int numberOfFloors = 12;
    private Door door = new Door();
    private Elevator.Direction direction = Elevator.Direction.NONE;
    private Vector<User> calls = new Vector<>();
    private Vector<Integer> destinations = new Vector<>();
    private boolean isBusy = false;

    Elevator elevator = new Elevator(numberOfFloors, floor, calls, destinations);

    @Test
    public void getElevatorFloor() {
        int actual = this.floor;
        int expected = elevator.getElevatorFloor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void setFloor() {
        int actual = 5;
        elevator.setElevatorFloor(actual);
        int expected = elevator.getElevatorFloor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void getDoor() {
        Door actual = elevator.getDoor();
        Door expected = elevator.getDoor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertSame(message, actual, expected);
    }

    @Test
    public void getCalls() {
        Vector<User> actual = this.calls;
        Vector<User> expected = elevator.getCalls();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertSame(message, actual, expected);
    }

    @Test
    public void setCalls() {
        int actual = 5;
        elevator.setElevatorFloor(actual);
        int expected = elevator.getElevatorFloor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void getDestinations() {
        Vector<Integer> actual = this.destinations;
        Vector<Integer> expected = elevator.getDestinations();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertSame(message, actual, expected);
    }

    @Test
    public void setDestinations() {
        Vector<Integer> actual = new Vector<>();
        destinations.add(1);
        destinations.add(4);
        destinations.add(8);

        elevator.setDestinations(actual);

        Vector<Integer> expected = elevator.getDestinations();

        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void getDirection() {
        Elevator.Direction actual = this.direction;
        Elevator.Direction expected = elevator.getDirection();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void setDirection() {
        Elevator.Direction actual = Elevator.Direction.DOWN;
        elevator.setDirection(actual);

        Elevator.Direction expected = elevator.getDirection();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void isBusy() {
        boolean actual = this.isBusy;
        boolean expected = elevator.isBusy();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertFalse(message, expected);
    }

    @Test
    public void setBusy() {
        boolean actual = true;

        elevator.setBusy(actual);
        boolean expected = elevator.isBusy();

        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void getNumberOfFloors() {
        int actual = this.numberOfFloors;
        int expected = elevator.getNumberOfFloors();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @Test
    public void setNumberOfFloors() {
        int actual = 20;

        elevator.setNumberOfFloors(actual);

        int expected = elevator.getNumberOfFloors();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);

    }

    @Test
    public void isOpen() {
        boolean actual = door.isOpen();
        boolean expected = elevator.isOpen();

        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }
}