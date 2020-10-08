package com.stella;

public class User {
    private int floor;
    private Elevator.Direction direction;
    private int destination;

    private boolean isInElevator;
    private boolean isDistracted;

    public User () {
        this.isInElevator = false;
        this.isDistracted = false;
    }

    public User(int floor, Elevator.Direction direction, int destination) {
        this.floor = floor;
        this.direction = direction;
        this.destination = destination;

        this.isInElevator = false;
        this.isDistracted = false;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Elevator.Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Elevator.Direction direction) {
        this.direction = direction;
    }

    public int getDestination() {
        return this.destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public boolean isDistracted() {
        return this.isDistracted;
    }

    public void setDistracted(boolean distracted) {
        this.isDistracted = distracted;
    }

    public boolean isInElevator() {
        return this.isInElevator;
    }

    public void setInElevator(boolean inElevator) {
        this.isInElevator = inElevator;
    }

    public void enterElevator () {
        this.setInElevator(true);
        System.out.println("User Entered Elevator");
    }

    public void exitElevator () {
        this.setInElevator(false);
        System.out.println("User Exited Elevator");
    }
}