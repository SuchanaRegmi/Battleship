/*
 * Ships.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * Main.java contains the code that runs the entire program. AddCompShips.java 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. AddPlayerShips. java contains code that allows and guides the player 
 * to choose valid coordinates to place their ships. ComputerTurn.java contains 
 * code that allows the computer to guess coordinates. It guesses randomly at 
 * first, then strategically guesses them after a hit. PlayerTurn.java contains 
 * code that allows and guides the player to guess valid coordinates. 
 * GameBoard.java contains code that prints out the arrays that hold the player 
 * and computer's battlefields. This file contains code that holds information 
 * about the ships (names and sizes). Targets.java contains code that defines 
 * Target objects.
 */


public class Ships {

    /* 
     * This method holds the ships' names. It takes in the index and returns
     * the ship in that index in the SHIPNAMES array.
     */
    public static String shipNames(int index) {
        final String[] SHIPNAMES = {"Carrier", "Battleship", "Cruiser",
            "Submarine", "Patrol"};

        String shipName = SHIPNAMES[index];

        return shipName;
    }

    /* 
     * This method holds the ships' sizes. It takes in the index and returns
     * the ship size in that index in the SHIPSIZES array.
     */
    public static int shipSize(int index) {
        final int[] SHIPSIZES = {4, 3, 3, 2, 2};

        int shipSize = SHIPSIZES[index];

        return shipSize;
    }
}
