//package hu.headswitcher.kata;

import java.util.*;

class Elevator {
    Integer elevatorFloor; // floor on which this elevator is found
    Integer elevatorPos; // position of the elevator on its floor

    public Elevator(Integer elevatorFloor, Integer elevatorPos) {
        this.elevatorFloor = elevatorFloor;
        this.elevatorPos = elevatorPos;
    }
}

class Exit {

    Integer exitFloor;// floor on which the exit is found
    Integer exitPos;// position of the exit on its floor

    public Exit(Integer exitFloor, Integer exitPos) {
        this.exitFloor = exitFloor;
        this.exitPos = exitPos;
    }
}

class Clone {

    int cloneFloor; // floor of the leading clone
    int clonePos; // position of the leading clone on its floor
    String direction;// direction of the leading clone: LEFT or RIGHT

    public Clone(int cloneFloor, int clonePos, String direction) {
        this.cloneFloor = cloneFloor;
        this.clonePos = clonePos;
        this.direction = direction;
    }
}

class Player {

    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";

    public static void main(String args[]) {

        ArrayList<Elevator> elevators = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        Exit exit = new Exit(in.nextInt(), in.nextInt());
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        for (int i = 0; i < nbElevators; i++) {
            elevators.add(new Elevator(in.nextInt(), in.nextInt()));
        }

        // game loop
        while (true) {
            Clone clone = new Clone(in.nextInt(), in.nextInt(), in.next());

            if (isCloneAtEdge(width, clone.clonePos) || !isCloneHeadingGoodDirection(elevators, clone, exit)) {
                System.out.println("BLOCK");
            } else {
                System.out.println("WAIT");
            }
        }
    }

    private static boolean isCloneHeadingGoodDirection(ArrayList<Elevator> elevators, Clone clone, Exit exit) {
        if (exit.exitFloor == clone.cloneFloor) {
            return isWrongWay(clone.direction, clone.clonePos, exit.exitPos);
        } else {
            for (Elevator elevator : elevators) {
                if (elevator.elevatorFloor == clone.cloneFloor && clone.clonePos != elevator.elevatorPos) {
                    return isWrongWay(clone.direction, clone.clonePos, elevator.elevatorPos);
                }
            }
        }
        return true;
    }

    private static boolean isWrongWay(String cloneDirection, int clonePos, int targetPos) {
        return cloneDirection.equals(LEFT) && targetPos < clonePos || cloneDirection.equals(RIGHT) && targetPos > clonePos;
    }

    private static boolean isCloneAtEdge(int width, int clonePos) {
        return clonePos + 1 == width || clonePos - 1 == -1;
    }
}