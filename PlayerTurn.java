/*
 * PlayerTurn.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * Main.java contains the code that runs the entire program. AddCompShips.java 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. AddPlayerShips. java contains code that allows and guides the player 
 * to choose valid coordinates to place their ships. ComputerTurn.java contains 
 * code that allows the computer to guess coordinates. It guesses randomly at 
 * first, then strategically guesses them after a hit. This file contains 
 * code that allows and guides the player to guess valid coordinates. 
 * GameBoard.java contains code that prints out the arrays that hold the player 
 * and computer's battlefields. Ships.java contains code that holds information 
 * about the ships (names and sizes). Targets.java contains code that defines 
 * Target objects.
 */

 

 import java.util.ArrayList;
 import javax.swing.JOptionPane;
 
 public class PlayerTurn {
 
     /* 
      * This method prompts the user to enter coordinates to guess, checks if 
      * it is a valid guess and outputs the necessary symbols depending on the 
      * the types of symbols the computer has in that coordinate.
      */
     public static void playerGuess(String[][] playerOcean,
             String[][] computerOcean, Targets targets) {
 
         // Objects and variables used in the do while loop
         ArrayList<Boolean> errors = new ArrayList<Boolean>();
         String playerXGuess;
         String playerYGuess;
         int x;
         int y;
 
         // Continously prompts user to enter X and Y coordinates to guess
         // until it is a valid guess.(Not outside of the battle field and 
         // has not guessed already).
         do {
             errors.clear();
 
             playerXGuess = JOptionPane.showInputDialog(null, "Enter a X "
                     + "coordinate to try and hit one of the computer's "
                     + "ships: ");
 
             playerYGuess = JOptionPane.showInputDialog(null, "Enter a Y "
                     + "coordinate to try and hit one of the computer's ships\n"
                     + "or Q - Give up: ");
 
             try {
                 // Input must be numbers or the letter q to quit, if not the 
                 // user will be asked to reenter
                 if ((playerXGuess.matches("[0-9]+"))
                         && (playerYGuess.matches("[0-9Q]+"))) {
 
                     x = Integer.parseInt(playerXGuess);
                     y = Integer.parseInt(playerYGuess);
 
                     // The coordinates must be within the battle field, if not 
                     // the user will be asked to reenter
                     if ((x >= 0 && x <= 6) && (y >= 0 && y <= 6)) {
 
                         // Checks different situations to see what type of 
                         // symbols to output on the boards.
                         // If in the guessed coordinate, the user has a target 
                         // in the same coordinate as the computer:
                         if (" X ".equals(playerOcean[y][x])
                                 && " O ".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             computerOcean[y][x] = " % ";
                             playerOcean[y][x] = " X%";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the user has a
                             // target in the same coordinate as the computer and
                             // the computer has already guessed that coordinate:
                         } else if (" X ".equals(playerOcean[y][x])
                                 && " O@".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             computerOcean[y][x] = " % ";
                             playerOcean[y][x] = " X%";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer has a 
                             // target which they have guessed and gotten a hit:
                         } else if (" ! ".equals(playerOcean[y][x])
                                 && " O!".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             computerOcean[y][x] = " !%";
                             playerOcean[y][x] = " !%";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer had 
                             // already guessed that coordinate and has a target:
                         } else if (" O@".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             playerOcean[y][x] = " % ";
                             computerOcean[y][x] = " %@";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the user has been 
                             // hit and the user misses 
                         } else if (" ! ".equals(playerOcean[y][x])) {
 
                             // Places symbol and shows message user missed
                             playerOcean[y][x] = " !@";
                             System.out.println("You missed!");
 
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer has a 
                             // target and has hit the player:
                         } else if (" O!".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             playerOcean[y][x] = " !%";
                             computerOcean[y][x] = " % ";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer has a 
                             // target 
                         } else if (" O ".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user hit, and how 
                             // many more targets there are remaining
                             playerOcean[y][x] = " % ";
                             computerOcean[y][x] = " % ";
                             System.out.println("You hit one of computer's "
                                     + "targets!");
 
                             targets.setTargetsComp();
                             System.out.println("There are "
                                     + targets.getTargetsComp() + " of "
                                     + "computer's ship targets remaining.");
                             errors.add(false);
 
                             // If in the guessed coordinate, the user has a 
                             // target but the computer just has water:
                         } else if (" ~ ".equals(computerOcean[y][x])
                                 && " X ".equals(playerOcean[y][x])) {
 
                             // Places symbol and shows message user missed
                             playerOcean[y][x] = " X@";
                             System.out.println("You missed!");
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer just 
                             // has water
                         } else if (" ~ ".equals(computerOcean[y][x])) {
 
                             // Places symbol and shows message user missed
                             playerOcean[y][x] = " @ ";
                             System.out.println("You missed!");
                             errors.add(false);
 
                             // If in the guessed coordinate, the computer has 
                             // nothing but had missed previously 
                         } else if (" @ ".equals(
                                 computerOcean[y][x])) {
 
                             // Places symbol and shows message user missed
                             playerOcean[y][x] = " @ ";
                             System.out.println("You missed!");
                             errors.add(false);
 
                             // If the user has already guessed that coordinate,
                             // will be asked to guess again
                         } else if ((" % ".equals(playerOcean[y][x]))
                                 || " @ ".equals(playerOcean[y][x])
                                 || " X@".equals(playerOcean[y][x])
                                 || " X%".equals(playerOcean[y][x])
                                 || " !@".equals(playerOcean[y][x])
                                 || " !%".equals(playerOcean[y][x])) {
 
                             JOptionPane.showMessageDialog(null, "You have "
                                     + "already guessed that coordinate."
                                     + " Please retry.");
                             errors.add(true);
                         }
 
                     } else {
 
                         // If user enters a number not in the battle field
                         errors.add(true);
                         JOptionPane.showMessageDialog(null, "The coordinates "
                                 + "cannot be less than 0 or greater than 6! "
                                 + "Please retry.");
                     }
 
                 } else if ((playerYGuess.toUpperCase().equals("Q"))
                         || playerYGuess.toUpperCase().equals("q")) {
 
                     // If user wishes to quit, program quits
                     System.out.println("\n\nYou automatically lose.\nThis was"
                             + " computer's battle field: ");
                     GameBoard.printComputerOcean(computerOcean);
                     System.exit(0);
 
                 } else {
 
                     // If the user enters coordinates that are not numbers
                     errors.add(true);
                     JOptionPane.showMessageDialog(null, "The coordinates must"
                             + " be numbers! Please retry.");
                 }
             } catch (NullPointerException nPe) {
 
                 // If user does not enter anything
                 errors.add(true);
                 JOptionPane.showMessageDialog(null, "You "
                         + "cannot leave input empty.\n" + nPe);
                 GameBoard.clearPlayerOcean(playerOcean);
                 break;
 
             }
 
         } while (errors.contains(true));
 
     }
 
 }
 