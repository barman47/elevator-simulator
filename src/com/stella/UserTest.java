package com.stella;

import org.junit.Assert;

public class UserTest {
    private int floor = 2;
    private Elevator.Direction direction = Elevator.Direction.UPSTAIRS;
    private int destination = 5;

    private User user = new User(floor, direction, destination);

    @org.junit.Test
    public void getFloor() {
        int actual = floor;
        int expected = user.getFloor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void setFloor() {
        int actual = 5;
        this.user.setFloor(actual);
        int expected = user.getFloor();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void getDirection() {
        Elevator.Direction actual = this.direction;
        Elevator.Direction expected = user.getDirection();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void setDirection() {
        Elevator.Direction actual = Elevator.Direction.UPSTAIRS;
        this.user.setDirection(actual);
        Elevator.Direction expected = user.getDirection();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void getDestination() {
        int actual = this.destination;
        int expected = user.getDestination();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void setDestination() {
        int actual = 12;
        this.user.setDestination(actual);
        int expected = user.getDestination();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void isDistracted() {
        boolean actual = false;
        boolean expected = this.user.isDistracted();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void setDistracted() {
        boolean actual = true;
        this.user.setDistracted(actual);
        boolean expected = this.user.isDistracted();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void isInElevator() {
        boolean actual = false;
        boolean expected = this.user.isInElevator();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void setInElevator() {
        boolean actual = true;
        this.user.setInElevator(actual);
        boolean expected = this.user.isInElevator();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void enterElevator() {
        boolean actual = true;
        this.user.enterElevator();
        boolean expected = this.user.isInElevator();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }

    @org.junit.Test
    public void exitElevator() {
        boolean actual = false;
        this.user.exitElevator();
        boolean expected = this.user.isInElevator();
        String message = "Expected " + expected + " but found " + actual;
        Assert.assertEquals(message, actual, expected);
    }
}