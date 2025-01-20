/*
 * Targets.java
 *
 * Suchana Regmi
 *
 * Main.java allows you to play a game of battleship with the computer. 
 * This file contains the code that runs the entire program. AddCompShips.java 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. AddPlayerShips. java contains code that allows and guides the player 
 * to choose valid coordinates to place their ships. ComputerTurn.java contains 
 * code that allows the computer to guess coordinates. It guesses randomly at 
 * first, then strategically guesses them after a hit. PlayerTurn.java contains 
 * code that allows and guides the player to guess valid coordinates. 
 * GameBoard.java contains code that prints out the arrays that hold the player 
 * and computer's battlefields. Ships.java contains code that holds information 
 * about the ships (names and sizes). This file contains code that defines 
 * Target objects.
 */

 

 public class Targets {
 
     // Properties
     private static int targetsComp;
     private static int targetsPlayer;
 
     // Default constructor 
     Targets() {
         
         targetsComp = 14;
         targetsPlayer = 14;
     }
 
     /*
      * This method returns the number of targets there are remaining for the 
      * player.
      */
     public int getTargetsPlayer() {
         return targetsPlayer;
     }
 
     /*
      * This method subtracts one of player's targets when it is called. 
      */
     public void setTargetsPlayer() {
         targetsPlayer = targetsPlayer - 1;
     }
 
     /*
      * This method returns the number of targets there are remaining for the 
      * computer.
      */
     public int getTargetsComp() {
         return targetsComp;
     }
 
     /*
      * This method subtracts one of computer's targets when it is called. 
      */
     public void setTargetsComp() {
         targetsComp = targetsComp - 1;
     }
 
 }
 