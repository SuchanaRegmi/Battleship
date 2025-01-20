/*
 * Main.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * This file contains the code that runs the entire program. AddCompShips.java 
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
 import javax.swing.JOptionPane;
 
 public class Main {
 
     /*
      * This method checks if the user's input contains any numbers or characters,
      * if so then false is returned, if the input just contains letters, true
      * is returned.
      */
     public static boolean validateInput(String input) {
 
         if (input.matches("[a-zA-Z ]+")) {
             return true;
         } else {
             return false;
         }
     }
 
     /* 
      * This holds the do while loop that runs the game. It takes in the user's
      * name and facilitates the turns the player and computers get to guess 
      * until one of them wins.
      */
     public static void playGame(String name, String[][] playerOcean,
             String[][] computerOcean, ArrayList<Integer> possibleHits,
             Targets targets) {
 
         // Takes turns guessing the coordinates until either the 
         // computer has no more ship targets left or the user has 
         // none left
         do {
 
             PlayerTurn.playerGuess(playerOcean, computerOcean, targets);
             ComputerTurn.computerGuess(name.toUpperCase(), playerOcean,
                     computerOcean, possibleHits, targets);
 
             // Tells the user either they won or lost and reveals 
             // the computer's battle field 
             if (targets.getTargetsComp() == 0) {
 
                 int leftOverPlayer = targets.getTargetsPlayer();
 
                 for (int i = 0; i < leftOverPlayer; i++) {
                     targets.setTargetsPlayer();
                 }
 
                 System.out.println("You win! This was computer's "
                         + "battle field.");
                 GameBoard.fixCompEmptySpaces(computerOcean);
                 GameBoard.printComputerOcean(computerOcean);
                 break;
 
             } else if (targets.getTargetsPlayer() == 0) {
 
                 int leftOverComp = targets.getTargetsComp();
 
                 for (int i = 0; i < leftOverComp; i++) {
                     targets.setTargetsComp();
                 }
 
                 System.out.println("You lose! This was computer's "
                         + "battle field.");
                 GameBoard.fixCompEmptySpaces(computerOcean);
                 GameBoard.printComputerOcean(computerOcean);
                 break;
             }
 
         } while ((targets.getTargetsComp() != 0)
                 || (targets.getTargetsPlayer() != 0));
     }
 
     public static void main(String[] args) {
 
        JOptionPane.showMessageDialog(null, "- - - - - - - - WELCOME TO BATTLE SHIP - - - - - -"
                 + " - - ");
 
         // Variables and objects used in the do while loop
         String promptPlay;
         String name;
         String[][] playerOcean = new String[7][7];
         String[][] computerOcean = new String[7][7];
         ArrayList<Integer> possibleHits = new ArrayList<>();
 
         // Every time the game ends, the user is asked if they want to play,
         // quit or see how to play 
         do {
 
             // Setting up the game (clearing the battle field and resetting 
             // the number of targets each player has) 
             GameBoard.clearComputerOcean(computerOcean);
             GameBoard.clearPlayerOcean(playerOcean);
             Targets targets = new Targets();
 
             promptPlay = JOptionPane.showInputDialog("Do you want to play?\n"
                     + "Y - yes\nN - no\nR- see how to play ");
 
             // User's input is checked. If the input is valid, the program 
             // continues, if not then user is shown a message and propted to 
             // re-enter.
             if (validateInput(promptPlay) == true) {
 
                 // If player wants to play, the game is set up and played.
                 // If player wants to see the rules, it is shown.
                 // If player does not want to play, the program is exited.
                 if (promptPlay.toUpperCase().equals("Y")
                         || promptPlay.toUpperCase().equals("YES")) {
 
                     name = JOptionPane.showInputDialog("Enter username: ");
 
                     // Setting up the game (adding ships)               
                     AddPlayerShips.placePlayerShips(name.toUpperCase(),
                             playerOcean);
                     AddCompShips.placeComputerShips(computerOcean);
 
                     // Calls the method playGame to begin guessing
                     // coordinates
                     playGame(name, playerOcean, computerOcean, possibleHits,
                             targets);
 
                 } else if (promptPlay.toUpperCase().equals("R")) {
 
                     System.out.println("\nThe objective of this game is to try"
                             + " and hit all of\nthe computer's ships' targets"
                             + " before it hits and sinks\nall of your ships.You"
                             + " try and hit the targets by\nentering the "
                             + "coordinates, from this board. The computer\nalso"
                             + " does the same. The computer's board will not be"
                             + " \nvisible so you must guess the coordinates of"
                             + " the ships.");
 
                 } else if (promptPlay.toUpperCase().equals("N")
                         || (promptPlay.toUpperCase().equals("NO"))) {
 
                     // Exits program
                     JOptionPane.showMessageDialog(null, "Goodbye!");
                     System.exit(0);
                 }
 
             } else {
 
                 // If input contains numbers or characters. 
                 JOptionPane.showMessageDialog(null, "Input cannot contain "
                         + "numbers or characters. Please retry.");
             }
 
         } while (!promptPlay.toUpperCase().equals("N")
                 || (!promptPlay.toUpperCase().equals("NO")));
 
     }
 
 }
 