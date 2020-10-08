package com.stella;

import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Elevator implements Runnable {
    private int numberOfFloors;
    private int elevatorFloor;
    private final Door door;
    private Vector<User> calls;
    private Vector<Integer> destinations;
    private Direction direction;

    private boolean isBusy;

    public Elevator() {
        this.direction = Direction.NONE;
        this.isBusy = false;
        this.door = new Door();
    }

    public Elevator(int numberOfFloors, int elevatorFloor, Vector<User> calls, Vector<Integer> destinations) {
        this.numberOfFloors = numberOfFloors;
        this.elevatorFloor = elevatorFloor;
        this.door = new Door();
        this.calls = calls;
        this.destinations = destinations;
        this.direction = Direction.NONE;
        this.isBusy = false;
    }

    enum Direction {
        UPSTAIRS,
        DOWN,
        NONE
    }

    public int getElevatorFloor() {
        return elevatorFloor;
    }

    public void setElevatorFloor(int elevatorFloor) {
        this.elevatorFloor = elevatorFloor;
    }

    public Door getDoor() {
        return this.door;
    }

    public Vector<User> getCalls() {
        return calls;
    }

    public void setCalls(Vector<User> calls) {
        this.calls = calls;
    }

    public Vector<Integer> getDestinations() {
        return destinations;
    }

    public void setDestinations(Vector<Integer> destinations) {
        this.destinations = destinations;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void callElevator (User user) throws InterruptedException {
        int userIndex = this.calls.indexOf(user);
        System.out.println("User called Elevator");
        if (this.isBusy) {
            return;
//            System.out.println(Thread.currentThread() + " Waiting");
//            this.wait();
        }
        this.setBusy(true);
        if (this.direction == Direction.NONE || !calls.isEmpty()) {
            // Set elevator to move to the elevatorFloor where user called from
            setDirection(chooseDirection(this.elevatorFloor, user.getFloor()));
            // Open elevator door if necessary (if door is not open)
            if (!this.door.isOpen()) {
                this.door.open();
            }

            System.out.printf("Elevator At Floor %d.\n", user.getFloor());
            user.enterElevator();
            System.out.printf("User entered destination: Floor %d.\n", user.getFloor());

            int userDestination = user.getDestination();
            Vector<Integer> destinations = new Vector<>(this.getDestinations());
            destinations.add(userDestination);
            setDestinations(destinations);

            System.out.println("Closing Elevator Door . . .");

            // Wait 2 seconds for elevator door to close
            TimeUnit.SECONDS.sleep(2);

            chooseDirection(this.elevatorFloor, user.getFloor());
            System.out.printf("Elevator at destination: Floor %d.\n", user.getDestination());
            user.exitElevator();
            this.door.close();
            System.out.println("Elevator Door Closed");

            //Deleting the call and destination for the call
            calls.remove(user);
            removeDestination(user);
        } else if (!this.door.isOpen() || this.direction != user.getDirection()) {
            if (this.calls.isEmpty()) {
                setDirection(chooseDirection(elevatorFloor, user.getFloor()));
                this.door.open();
                if (user.isDistracted()) {
                    // then don't enter elevator
                    this.door.close();
                } else {
                    // enter elevator
                    user.enterElevator();
                    System.out.println("User destination is Floor " + user.getDestination());
                }
            }
        }
    }

    private Direction chooseDirection (int currentFloor, int userFloor) {
        if (currentFloor < userFloor) {
            // Move elevator upwards to user elevatorFloor or call elevatorFloor
            System.out.println("Elevator Moving " + Direction.UPSTAIRS);
            this.setElevatorFloor(userFloor);
            return goUp(Direction.UPSTAIRS);
        } else if (currentFloor > userFloor) {
            // Move elevator downwards to user elevatorFloor or call elevatorFloor
            System.out.println("Elevator Moving " + Direction.DOWN);
            this.setElevatorFloor(userFloor);
            return goDown(Direction.DOWN);
        } else {
            return Direction.NONE;
        }
    }

    private Direction goUp (Direction direction) {
        // Sorted Vector of destinations
        Vector<Integer> sortedDestinations = sortDestinations(this.destinations);

        // check if current elevatorFloor = highest destination or elevatorFloor
        if (this.elevatorFloor == sortedDestinations.elementAt(sortedDestinations.size() - 1)) {
            // reverse the direction
            this.setElevatorFloor(this.getElevatorFloor() - 1);
            setDirection(Direction.DOWN);
            return Direction.DOWN;
        } else {
            // do not reverse the direction, go up.
            this.setElevatorFloor(this.getElevatorFloor() + 1);
            this.setDirection(direction);
            return direction;
        }
    }

    private Direction goDown (Direction direction) {
        // Sorted Vector of destinations
        Vector<Integer> sortedDestinations = sortDestinations(this.destinations);
        if (this.elevatorFloor == sortedDestinations.get(0)) {
            // reverse direction if at the lowest elevatorFloor
            setElevatorFloor(getElevatorFloor() + 1);
            setDirection(Direction.UPSTAIRS);
            return Direction.UPSTAIRS;
        } else {
            // Go down
            this.setElevatorFloor(this.getElevatorFloor() - 1);
            this.setDirection(direction);
            return direction;
        }
    }

    private void removeDestination (User user) throws InterruptedException {
        this.setBusy(false);
        int userDestination = user.getDestination();
        int indexToRemove = this.destinations.indexOf(userDestination);
        this.destinations.remove(indexToRemove);
        if (!destinations.isEmpty()) {
            int nextDestination = destinations.get(0);
            if (nextDestination > this.elevatorFloor) {
                goDown(Direction.DOWN);
            } else {
                goUp(Direction.UPSTAIRS);
            }
        }
        if (!this.calls.isEmpty()) {
            this.callElevator(this.calls.get(0));
        }
    }

    private Vector<Integer> sortDestinations (Vector<Integer> destinations) {
        Vector<Integer> sortedDestinations = destinations;
        Collections.sort(sortedDestinations);
        return sortedDestinations;
    }

    public boolean isOpen () {
        return door.isOpen();
    }

    public void run () {
        try {
//            callElevator(this.calls.get(this.calls.size() - this.calls.size()));
            callElevator(this.calls.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
