/*
 * GameBoard.java
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
 * This file contains code that prints out the arrays that hold the player 
 * and computer's battlefields. Ships.java contains code that holds information 
 * about the ships (names and sizes). Targets.java contains code that defines 
 * Target objects.
 */

import javax.swing.JOptionPane;

public class GameBoard {
 
     /*
      * This method takes in the player's name, creates the player's battle field 
      * and displays the empty battle field.
      */
     public static void createPlayerOcean(String name, String[][] playerOcean) {
         System.out.println("\n************************************************"
                 + "*******");
         System.out.println("\n" + name + "'s empty battle field:");
 
         // First part of ocean (displaying numbers)
         System.out.print("   ");
         for (int i = 0; i < 7; i++) {
             System.out.print(i + "  ");
 
         }
         System.out.println("\n   _  _  _  _  _  _  _   ");
 
         // Middle part of ocean (adding water + border + numbers)
         for (int i = 0; i < playerOcean.length; i++) {
             for (int j = 0; j < playerOcean[i].length; j++) {
 
                 playerOcean[i][j] = " ~ ";
 
                 // Adds border on the sides
                 if (j == 0) {
 
                     System.out.print(i + "|" + playerOcean[i][j]);
 
                 } else if (j == playerOcean[i].length - 1) {
 
                     System.out.print(playerOcean[i][j] + "|" + i);
 
                 } else {
                     System.out.print(playerOcean[i][j]);
                 }
             }
             System.out.println();
         }
 
         // Last part of ocean (displaying numbers)
         System.out.print("   -  -  -  -  -  -  -   \n");
         for (int i = 0; i < 7; i++) {
 
             if (i == 0) {
 
                 System.out.print("   " + i + "  ");
 
             } else {
                 System.out.print(i + "  ");
             }
         }
         System.out.println("\n");
 
     }
 
     /*
      * This method creates the computer's battle field and displays the empty 
      * battle field.
      */
     public static void createComputerOcean(String[][] computerOcean) {
         System.out.println("\n************************************************"
                 + "*******");
         System.out.println("\nComputer's empty battle field:");
 
         // First part of ocean (displaying numbers)
         System.out.print("   ");
         for (int i = 0; i < 7; i++) {
             System.out.print(i + "  ");
 
         }
         System.out.println("\n   _  _  _  _  _  _  _   ");
 
         // Middle part of ocean (adding water + border + numbers)
         for (int i = 0; i < computerOcean.length; i++) {
             for (int j = 0; j < computerOcean[i].length; j++) {
 
                 computerOcean[i][j] = " ~ ";
 
                 // Adds border on the sides
                 if (j == 0) {
 
                     System.out.print(i + "|" + computerOcean[i][j]);
 
                 } else if (j == computerOcean[i].length - 1) {
 
                     System.out.print(computerOcean[i][j] + "|" + i);
 
                 } else {
                     System.out.print(computerOcean[i][j]);
                 }
             }
             System.out.println();
         }
 
         // Last part of ocean (displaying numbers)
         System.out.print("   -  -  -  -  -  -  -   \n");
         for (int i = 0; i < 7; i++) {
             if (i == 0) {
                 System.out.print("   " + i + "  ");
             } else {
                 System.out.print(i + "  ");
             }
         }
         System.out.println("\n");
     }
 
     /* 
      * This method is called if the user makes a mistake placing one of the 
      * ships in the begginning. It clears the middle section of the user's 
      * battle field so they can reposition their ships from the start.
      */
     public static void clearPlayerOcean(String[][] PlayerOcean) {
 
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 7; j++) {
                 PlayerOcean[i][j] = " ~ ";
             }
         }
     }
 
     /* 
      * This method is called if the computer makes a mistake placing one of the 
      * ships in the begginning. It clears the middle section of the computer's 
      * battle field so the computer can reposition its ships from the start.
      */
     public static void clearComputerOcean(String[][] ComputerOcean) {
 
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 7; j++) {
                 ComputerOcean[i][j] = " ~ ";
             }
         }
     }
 
     /*
      * This method replaces empty spaces ("null") of the computer's map
      * with ~ at the end of the game when displaying the computer's map to the 
      * user.
      */
     public static void fixCompEmptySpaces(String[][] ComputerOcean) {
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 7; j++) {
 
                 if (ComputerOcean[i][j] == null) {
                     ComputerOcean[i][j] = " ~ ";
                 }
             }
         }
     }
 
     /* 
      * This method is called when there is a change to the player's battle 
      * field. It takes the array that holds the battle field and prints it out.
      */
     public static void printPlayerOcean(String name, String[][] playerOcean) {

        StringBuilder board = new StringBuilder();
        board.append(name).append("'s battle field:\n\n");

        // First part of ocean (displaying numbers)
        board.append("   ");
        for (int i = 0; i < 7; i++) {
            board.append(i).append("  ");
        }
        board.append("\n   _  _  _  _  _  _  _   \n");

        // Middle part of the ocean
        for (int x = 0; x < playerOcean.length; x++) {
            board.append(x).append("|");
            for (String item : playerOcean[x]) {
                board.append(item);
            }
            board.append("|").append(x).append("\n");
        }

        // Last part of ocean (displaying numbers)
        board.append("   -  -  -  -  -  -  -   \n");
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                board.append("   ").append(i).append("  ");
            } else {
                board.append(i).append("  ");
            }
        }
        board.append("\n\n1. ~ is water\n2. @ is missed spots\n3. X is your ships\n"
                + "4. ! is your ships that have been sunk by the computer\n"
                + "5. % is computer's ships that you sunk\n");

        // Display the game board using JOptionPane
        JOptionPane.showMessageDialog(null, board.toString(), name + "'s Battle Field", JOptionPane.INFORMATION_MESSAGE);
     }

 
     /* 
      * This method is called at the end of the game to display the computer's 
      * battle field and show the user where the computer guessed and hit ship 
      * targets. It takes the array that holds the battle field and prints it 
      * out.
      */
      public static void printComputerOcean(String[][] computerOcean) {
        StringBuilder board = new StringBuilder();
        board.append("Computer's battle field:\n\n");
    
        // First part of ocean (displaying numbers)
        board.append("   ");
        for (int i = 0; i < 7; i++) {
            board.append(i).append("  ");
        }
        board.append("\n   _  _  _  _  _  _  _   \n");
    
        // Middle part of the ocean
        for (int x = 0; x < computerOcean.length; x++) {
            board.append(x).append("|");
            for (String item : computerOcean[x]) {
                board.append(item);
            }
            board.append("|").append(x).append("\n");
        }
    
        // Last part of ocean (displaying numbers)
        board.append("   -  -  -  -  -  -  -   \n");
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                board.append("   ").append(i).append("  ");
            } else {
                board.append(i).append("  ");
            }
        }
        board.append("\n\n1. ~ is water\n2. @ is missed spots\n3. O is computer's ships\n"
                + "4. % is computer's ships that have sunk\n"
                + "5. ! is your ships that the computer sunk\n\n");
    
        // Display the game board using JOptionPane
        JOptionPane.showMessageDialog(null, board.toString(), "Computer's Battle Field", JOptionPane.INFORMATION_MESSAGE);
      }
}

    