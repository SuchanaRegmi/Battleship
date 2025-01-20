/*
 * AddPlayerShips.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * Main.java contains the code that runs the entire program. AddCompShips.java 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. This file contains code that allows and guides the player 
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
 import javax.swing.JOptionPane;
 
 public class AddPlayerShips {
 
     /* 
      * This method prompts user to enter coordinates to place ships, checks if 
      * coordinates are valid, places them and calls GameBoard.printPlayerOcean
      * method to display the battle field with the new ship added.
      */
     public static void placePlayerShips(String name, String[][] playerOcean) {
 
         // Creating the battle field
         GameBoard.createPlayerOcean(name, playerOcean);
 
         // Objects and variables used in the do while loop
         ArrayList<Boolean> errors = new ArrayList<Boolean>();
         String xInput;
         String yInput;
         String orientationInput;
         int x;
         int y;
         int orientation;
 
         // Continously prompts user to enter their ships until all of them are
         // in valid locations.
         do {
             errors.clear();
 
             // Loops 5 times to add ships on the battle field
             outerloop:
             for (int i = 0; i < 5; i++) {
 
                 // Prompt user for coordinates and direction 
                 xInput = JOptionPane.showInputDialog("Place "
                         + "your ships within the available battle field:\n"
                         + "Enter a X coordinate for your "
                         + Ships.shipNames(i) + " ship (size "
                         + Ships.shipSize(i) + "): ");
 
                 yInput = JOptionPane.showInputDialog("Place "
                         + "your ships within the available battle field:\n"
                         + "Enter a Y coordinate for your "
                         + Ships.shipNames(i) + " ship (size "
                         + Ships.shipSize(i) + "): ");
 
                 orientationInput = JOptionPane.showInputDialog("How"
                         + "do you want to place your " + Ships.shipNames(i)
                         + " ship, \n(1) - Horizontally\n(2) - Vertically:");
 
                 try {
 
                     // Input must be numbers, if not will be asked to reenter
                     if ((xInput.matches("[0-9]+")) && (yInput.matches("[0-9]+"))
                             && (orientationInput.matches("[0-9]+"))) {
 
                         // Converting to integers from strings
                         x = Integer.parseInt(xInput);
                         y = Integer.parseInt(yInput);
                         orientation = Integer.parseInt(orientationInput);
 
                         // If the user chooses coordinates outside of the battle 
                         // field, they will be asked to re-enter. 
                         if ((x >= 0 && x < 7) && (y >= 0 && y < 7)) {
 
                             // Checks to see if the starting coordinate overlaps 
                             // with another ship
                             if (" X ".equals(playerOcean[y][x])) {
 
                                 errors.add(true); 
                                 JOptionPane.showMessageDialog(null, "You can't "
                                         + "place more than one boat in the same "
                                         + "location! Please re-enter the "
                                         + "positioning of all your ships.");
                                 GameBoard.clearPlayerOcean(playerOcean);
                                 break;
 
                             } else if (" ~ ".equals(playerOcean[y][x])) {
 
                                 // Looops the number of times the ship size is 
                                 // to place the targets
                                 for (int j = 0; j < Ships.shipSize(i); j++) {
 
                                     // If user would like to place the ship 
                                     // horizontally 
                                     if (orientation == 1) {
 
                                         // Checks to see if ship will go out of 
                                         // the battle field. Then checks if 
                                         // there is already a ship in that 
                                         // position or will overlap. If both 
                                         // those conditions are true, the user 
                                         // will need to start over. If the 
                                         // conditions are both false, the 
                                         // ship will be placed in the user's 
                                         // desired location.
                                         if ((x + (Ships.shipSize(i) - 1)) > 6) {
 
                                             errors.add(true); 
                                             JOptionPane.showMessageDialog(null,
                                                     "The ship will go out of the "
                                                     + "battle field. Please "
                                                     + "re-enter the positioning"
                                                     + " of all your ships.");
                                             GameBoard.clearPlayerOcean(playerOcean);
                                             break outerloop;
                                         } else if (" X "
                                                 .equals(playerOcean[y][x + j])) {
 
                                             errors.add(true); 
                                             JOptionPane.showMessageDialog(null,
                                                     "You can't place more than "
                                                     + "one boat in the "
                                                     + "same location! "
                                                     + "Please re-enter the "
                                                     + "positioning of all your "
                                                     + "ships.");
                                             GameBoard.clearPlayerOcean(playerOcean);
                                             break outerloop;
                                         } else {
 
                                             errors.add(false);                                            
                                             playerOcean[y][x + j] = " X ";
                                         }
 
                                         // If user would like to place the ship 
                                         // vertically
                                     } else if (orientation == 2) {
 
                                         // Checks to see if ship will go out of 
                                         // the battle field. Then checks if 
                                         // there is already a ship in that 
                                         // position or will overlap. If both 
                                         // those conditions are true, the user 
                                         // will need to start over. If the 
                                         // conditions are both false, the 
                                         // ship will be placed in the user's 
                                         // desired location.
                                         if ((y + (Ships.shipSize(i) - 1)) > 6) {
 
                                             errors.add(true); 
                                             JOptionPane.showMessageDialog(null,
                                                     "The ship will go out of "
                                                     + "the battle field. Please "
                                                     + "re-enter the positioning"
                                                     + " of all your ships.");
                                             GameBoard
                                                     .clearPlayerOcean(playerOcean);
                                             break outerloop;
                                         } else if (" X ".
                                                 equals(playerOcean[y + j][x])) {
 
                                             errors.add(true);                                            
                                             JOptionPane.showMessageDialog(null,
                                                     "You can't place more than "
                                                     + "one boat in the "
                                                     + "same location! "
                                                     + "Please re-enter the "
                                                     + "positioning of all your "
                                                     + "ships.");
                                             GameBoard
                                                     .clearPlayerOcean(playerOcean);
                                             break outerloop;
                                         } else {
 
                                             errors.add(false);
                                             playerOcean[y + j][x] = " X ";
                                         }
                                     }
 
                                 }
 
                                 // Prints the game board with the new ship 
                                 // placed
                                 GameBoard.printPlayerOcean(name, playerOcean);
 
                             }
 
                         } else {
 
                             // If user enters coordinates outside the battle 
                             // field
                             errors.add(true);
                             JOptionPane.showMessageDialog(null, "You can't "
                                     + "place ships outside the available battle"
                                     + " field! Please re-enter the positioning "
                                     + "of your ships.");
                             GameBoard.clearPlayerOcean(playerOcean);
                             break;
 
                         }
                     } else {
 
                         // If user does not enter numbers
                         errors.add(true);
                         JOptionPane.showMessageDialog(null, "Input must be "
                                 + "numbers! Please retry.");
                         break;
 
                     }
 
                 } catch (NullPointerException nPe) {
 
                     // If user does not enter anything
                     errors.add(true);
                     JOptionPane.showMessageDialog(null, "You "
                             + "cannot leave input empty.\n" + nPe);
                     GameBoard.clearPlayerOcean(playerOcean);
                     break;
 
                 }
             }
         } while (errors.contains(true));
     }
 
 }
 