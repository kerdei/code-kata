package hu.headswitcher.kata.codingame.practice.medium.there_is_no_spoon_episode_1;

import java.util.*;

class Node {
    String right;
    String down;
    String pos;

    @Override
    public String toString() {
        return pos + " " + right + " " + down;
    }
}

class Player {

    public static final char POWERCELL_CHAR = '0';

    public static void main(String args[]) {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();

        for (int i = 0; i < height; i++) {
            grid.add(in.nextLine()); // width characters, each either 0 or .
        }

        for (int i = 0; i < grid.size(); i++) {

            String currentLine = grid.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                //print out current location of the POWERCELL_CHAR
                if (currentLine.charAt(j) == POWERCELL_CHAR) {
                    Node currentNode = new Node();
                    currentNode.pos = j + " " + i;

                    int currentLocationY = j + 1;

                    boolean foundSymbol = false;
                    while (currentLocationY < currentLine.length() && !foundSymbol) {

                        if (currentLine.charAt(currentLocationY) == POWERCELL_CHAR) {
                            foundSymbol = true;
                            //print out current location of the POWERCELL_CHAR
                            currentNode.right =currentLocationY + " " + i ;
                        }
                        currentLocationY++;
                    }
                    if (!foundSymbol) {

                        currentNode.right = "-1 -1";
                    }

                    currentLocationY = j;
                    int currentLocationX = i +1;
                    foundSymbol = false;

                    while (currentLocationX < grid.size() && !foundSymbol) {
                        String currentLineAtLocationX = grid.get(currentLocationX);

                        if (currentLineAtLocationX.charAt(currentLocationY) == POWERCELL_CHAR) {
                            foundSymbol = true;
                            currentNode.down =  currentLocationY + " " + currentLocationX;
                        }
                        currentLocationX++;
                    }
                    if (!foundSymbol) {
                        currentNode.down = "-1 -1";
                    }
                    nodes.add(currentNode);
                }
            }
        }

        for (Node node : nodes) {
            System.out.println(node);
        }

    }
}