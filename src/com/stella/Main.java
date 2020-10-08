package com.stella;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter Number of Floors in building: ");
//        int buildingFloors = scanner.nextInt();
//
//        System.out.print("Enter Elevator Floor: ");
//        int elevatorFloor = scanner.nextInt();
//
//        Vector<User> calls = new Vector<>();
//        Vector<Integer> destinations = new Vector<>();
//        Elevator elevator = new Elevator(buildingFloors, elevatorFloor, calls, destinations);
//        while (true) {
//            System.out.println("Press 1 to Enter a User: ");
//            int response = scanner.nextInt();
//
//            switch (response) {
//                case 1:
//                    User user = enterUser();
//                    calls.add(user);
//                    destinations.add(user.getDestination());
//                default:
//                    break;
//            }
//            System.out.println("");
//        }
//        Scanner scanner = new Scanner(System.in);

        User userOne = new User();
        userOne.setFloor(2);
        userOne.setDirection(Elevator.Direction.UPSTAIRS);

        User userTwo = new User();
        userTwo.setFloor(3);
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

    private static User enterUser () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user Floor: ");
        int userFloor = scanner.nextInt();
        System.out.print("Enter Direction: (e.g) UPSTAIRS, DOWN, or NONE: ");
        Elevator.Direction userDirection = Elevator.Direction.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter user destination floor: ");
        int userDestination = scanner.nextInt();

        User user = new User(userFloor, userDirection, userDestination);
        return user;
    }
}
