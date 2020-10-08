package com.stella;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        User userOne = new User();
        userOne.setFloor(2);
        userOne.setDestination(3);
        userOne.setDirection(Elevator.Direction.UPSTAIRS);

        User userTwo = new User();
        userTwo.setFloor(3);
        userTwo.setDestination(1);
        userTwo.setDirection(Elevator.Direction.DOWN);


        Vector<User> calls = new Vector<>();
        calls.add(userOne);
        calls.add(userTwo);

        Vector<Integer> destinations = new Vector<>();
        destinations.add(userOne.getDestination());
        destinations.add(userTwo.getDestination());

        Elevator elevator = new Elevator(12, 1, calls, destinations);
        Thread elevatorThread = new Thread(elevator);
        elevatorThread.start();
        Thread threadTwo = new Thread(elevator);
        threadTwo.start();
    }

}
