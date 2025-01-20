/*
 * AddCompShips.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * Main.java contains the code that runs the entire program. This file 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. AddPlayerShips. java contains code that allows and guides the player 
 * to choose valid coordinates to place their ships. ComputerTurn.java contains 
 * code that allows the computer to guess coordinates. It guesses randomly at 
 * first, then strategically guesses them after a hit. PlayerTurn.java contains 
 * code that allows and guides the player to guess valid coordinates. 
 * GameBoard.java contains code that prints out the arrays that hold the player 
 * and computer's battlefields. Ships.java contains code that holds information 
 * about the ships (names and sizes). Targets.java contains code that defines 
 * Target objects.
 */

 

 import java.util.ArrayList;
 
 public class AddCompShips {
 
     /* 
      * This method chooses randomly the orientation and coordinates of the ship, 
      * then checks if the coordinates are valid, if they are, it places them on 
      * the batle field, if not then new coordinates will be chosen.
      */
     public static void placeComputerShips(String[][] computerOcean) {
 
         // Creating the battle field
         GameBoard.createComputerOcean(computerOcean);
 
         // Objects and variables used in the do while loop
         ArrayList<Boolean> errors = new ArrayList<Boolean>();
         int x;
         int y;
         int orientation;
 
         System.out.println("\nComputer is placing ships..\n");
 
         // Loop 5 times to diplay names of the battle ship
         for (int k = 0; k < 5; k++) {
             System.out.println(Ships.shipNames(k) + " ship has been placed.\n");
         }
 
         // Continously chooses x and y coordinates until a valid coordinate is 
         // chosen 
         do {
             errors.clear();
 
             // Loops 5 times to add ships on the battle field
             outerloop:
             for (int i = 0; i < 5; i++) {
 
                 // Randomly decide the orientation of the ship
                 orientation = (int) (Math.random() * 2);
 
                 // Randomly decide the coordinates of the ship
                 x = (int) (Math.random() * 7);
                 y = (int) (Math.random() * 7);
 
                 // Checks to see if the starting coordinate overlaps 
                 // with another ship. If it is empty, it contiues to place the
                 // ship, if not it will choose another coordinate.
                 if (" O ".equals(computerOcean[y][x])) {
 
                     GameBoard.clearComputerOcean(computerOcean);
                     errors.add(true);
                     break;
 
                 } else if (" ~ ".equals(computerOcean[y][x])) {
 
                     // Looops the number of times the ship size is 
                     // to place the targets                    
                     for (int j = 0; j < Ships.shipSize(i); j++) {
 
                         // If a horizontal placement is chosen
                         if (orientation == 0) {
 
                             // Checks to see if ship will go out of the 
                             // battle field. Then checks if there is 
                             // already a ship in that position or will
                             // overlap. If both those conditions are
                             // true, the computer will need to choose 
                             // coordinates again. If the conditions are both 
                             // false, the ship will be placed in the user's 
                             // desired location.
                             if ((x + (Ships.shipSize(i) - 1)) > 6) {
                                 
                                 errors.add(true);
                                 break outerloop;
                             } else {
 
                                 if (" O ".equals(computerOcean[y][x + j])) {
                                     
                                     GameBoard.clearComputerOcean(computerOcean);
                                     errors.add(true);
                                     break outerloop;
                                 } else {
                                     
                                     computerOcean[y][x + j] = " O ";
                                 }
                             }
 
                             // If a vertical placement is chosen    
                         } else if (orientation == 1) {
 
                             // Checks to see if ship will go out of the 
                             // battle field. Then checks if there is 
                             // already a ship in that position or will
                             // overlap. If both those conditions are
                             // true, the computer will need to choose 
                             // coordinates again. If the conditions are both 
                             // false, the ship will be placed in the user's 
                             // desired location.
                             if ((y + (Ships.shipSize(i) - 1)) > 6) {
                                 
                                 errors.add(true);
                                 break outerloop;
                             } else {
 
                                 if (" O ".equals(computerOcean[y + j][x])) {
                                     
                                     GameBoard.clearComputerOcean(computerOcean);
                                     errors.add(true);
                                     break outerloop;
                                 } else {
                                     
                                     computerOcean[y + j][x] = " O ";
                                 }
                             }
                         }
 
                     }
 
                 }
             }
         } while (errors.contains(true));
     }
 }
 