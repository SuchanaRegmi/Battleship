/*
 * ComputerTurn.java
 *
 * Suchana Regmi
 *
 * This program allows you to play a game of battleship with the computer. 
 * Main.java contains the code that runs the entire program. AddCompShips.java 
 * contains code that allows the computer to choose coordinates to place its 
 * ships. AddPlayerShips.java contains code that allows and guides the player 
 * to choose valid coordinates to place their ships. This file contains 
 * code that allows the computer to guess coordinates. It guesses randomly at 
 * first, then strategically guesses them after a hit. PlayerTurn.java contains 
 * code that allows and guides the player to guess valid coordinates. 
 * GameBoard.java contains code that prints out the arrays that hold the player 
 * and computer's battlefields. Ships.java contains code that holds information 
 * about the ships (names and sizes). Targets.java contains code that defines 
 * Target objects.
 */


import java.util.ArrayList;

public class ComputerTurn {

    /* 
     * This method makes the computer randomly guess coordinates, checks if 
     * it is a valid guess and outputs the necessary symbols depending on the 
     * the types of symbols the player has in that coordinate. If the guess is
     * successful, then it guesses coordinates surrounding the hit.
     */
    public static void computerGuess(String name, String[][] playerOcean,
            String[][] computerOcean, ArrayList<Integer> possibleHits,
            Targets targets) {

        // Objacts and variables used in the do while loop
        ArrayList<Boolean> errors = new ArrayList<>();
        int x = 0;
        int y = 0;

        // Continously guesses a coordinate until a coordinate not previously 
        // guessed has been chosen 
        do {

            errors.clear();

            // If a coordinate has been previously hit, the computer will 
            // guess it's surrounding coordinates, if not it will guess a random
            // coordinate
            if (possibleHits.isEmpty()) {

                y = (int) (Math.random() * 7);
                x = (int) (Math.random() * 7);

            } else if (!possibleHits.isEmpty()) {

                // Guesses the first coordinates in the possibleHits arrayList
                // then takes it out of possibleHits array
                y = possibleHits.get(0);
                x = possibleHits.get(1);
                possibleHits.remove(0);
                possibleHits.remove(0);
            }

            // If the computer guesses coordinates inside the battle field, then
            // the computer moves on. If not the computer will guess another 
            // coordinate
            if ((x >= 0 && x <= 6) && ((y >= 0 && y <= 6))) {

                // Checks different situations to see what type of symbols 
                // to output on the boards.
                // If in the guessed coordinate, the user has a target 
                // in the same coordinate as the computer:
                if (" O ".equals(computerOcean[y][x])
                        && " X ".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    computerOcean[y][x]
                            = " O!";
                    playerOcean[y][x]
                            = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the user has a target 
                    // in the same coordinate as the computer and the user
                    // has already guessed that coordinate:
                } else if (" O ".equals(computerOcean[y][x])
                        && " X@".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    computerOcean[y][x] = " O!";
                    playerOcean[y][x] = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the user has a target 
                    // which they have guessed and gotten a hit:
                } else if (" O ".equals(computerOcean[y][x])
                        && " X%".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    computerOcean[y][x] = " O!";
                    playerOcean[y][x] = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the computer has a target 
                    // but the user just has water:    
                } else if (" O ".equals(computerOcean[y][x])
                        && " ~ ".equals(playerOcean[y][x])) {

                    // Places symbol and shows message computer missed
                    computerOcean[y][x] = " O@";
                    System.out.println("The computer missed!");
                    errors.add(false);

                    // If in the guessed coordinate, the computer and user both 
                    // have targets: 
                } else if (" O ".equals(computerOcean[y][x])
                        && " X ".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    computerOcean[y][x] = " O!";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the computer has been 
                    // hit and the computer misses 
                } else if (" % ".equals(computerOcean[y][x])) {

                    // Places symbol and shows message user missed
                    computerOcean[y][x] = " %@";
                    System.out.println("The computer missed missed!");

                    errors.add(false);

                    // If in the guessed coordinate, the player just has water
                } else if (" ~ ".equals(playerOcean[y][x])) {

                    // Places symbol and shows message computer missed
                    computerOcean[y][x] = " @ ";
                    System.out.println("The computer missed!");
                    errors.add(false);

                    // If in the guessed coordinate, the player does not have a
                    // target but had missed:
                } else if (" @ ".equals(
                        playerOcean[y][x])) {

                    // Places symbol and shows message computer missed
                    computerOcean[y][x] = " @ ";
                    System.out.println("The computer missed!");
                    errors.add(false);

                    // If in the guessed coordinate, the player had already 
                    // guessed that coordinate and has a target:
                } else if (" X@".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    playerOcean[y][x] = " !@";
                    computerOcean[y][x] = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the player has a target 
                    // and has hit the player:
                } else if (" X%".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    playerOcean[y][x] = " !%";
                    computerOcean[y][x] = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If in the guessed coordinate, the player has a target 
                } else if (" X ".equals(playerOcean[y][x])) {

                    // Sends the coordinates to updateTargets to guess
                    // surrounding coordinates next turn. Places symbols, 
                    // then shows message computer hit, and how 
                    // many more targets there are remaining
                    updateHits(x, y, possibleHits);
                    playerOcean[y][x] = " ! ";
                    computerOcean[y][x] = " ! ";
                    System.out.println("The computer hit one of your targets!");

                    targets.setTargetsPlayer();
                    System.out.println("There are "
                            + targets.getTargetsPlayer() + " of your "
                            + "ship targets remaining.");
                    errors.add(false);

                    // If the computer has already guessed that coordinate, it
                    // will guess another coordinate
                } else if (" @ ".equals(computerOcean[y][x])
                        || (" ! ".equals(computerOcean[y][x]))
                        || (" O!".equals(computerOcean[y][x]))
                        || (" O@".equals(computerOcean[y][x]))
                        || (" %@".equals(computerOcean[y][x]))) {

                    errors.add(true);

                }

            } else {

                // If the computer chooses a coordinate not in the battle field,
                // it will guess another one
                errors.add(true);
            }

        } while (errors.contains(true));

        // Displays the coordinates the computer guessed
        System.out.println("Computer guessed: (" + x + "," + y + ")");
        GameBoard.printPlayerOcean(name, playerOcean);

    }

    /*
     * This method takes in the coordinates that the computer hit and adds 
     * its surrounding coordinates to the possibleHits arrayList so that its
     * surrounding coordinates will be guessed on the computer's next turn, if 
     * possible. 
     */
    public static void updateHits(int computerXGuess, int computerYGuess,
            ArrayList<Integer> possibleHits) {

        // Adds coordinate below the hit target to the array
        possibleHits.add(computerYGuess + 1);
        possibleHits.add(computerXGuess);

        // Adds coordinate above the hit target to the array
        possibleHits.add(computerYGuess - 1);
        possibleHits.add(computerXGuess);

        // Adds coordinate to the right of hit target to the array
        possibleHits.add(computerYGuess);
        possibleHits.add(computerXGuess + 1);

        // Adds coordinate to the left of hit target to the array
        possibleHits.add(computerYGuess);
        possibleHits.add(computerXGuess - 1);
    }
}
