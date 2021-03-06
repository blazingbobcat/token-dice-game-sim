/* Token Dice Game Simulator
Implementation Class
June 4, 2021 */

import java.util.*;
import java.io.IOException;

class TokenDiceMain {

	public static long getNumGames(Scanner scan, String error) {

		long numOfGames = 0L; 

		// Get number of desired games
		do {
			
			try {
		
				// Prompt user for number of games
				System.out.println("\nPlease enter number of games: ");
				numOfGames = scan.nextLong();
								
				// See if user enters invalid number
				if (numOfGames < 1) {

					System.out.println("Games is less than 1.");
					numOfGames = 0L; // Return no games

				} // end if

			} catch (Exception e) {
			
				// Catch error String
				error = scan.next();
				System.out.println("ERROR:  Invalid Input.");
				numOfGames = 0L;

			} // end try-catch

		} while (numOfGames == 0L);

		return numOfGames;

	} // end function

	public static int askForQuit(Scanner scan, String error) {

		int ans = 2;

		do { 
			// Prompt user if they want to run simulation again
			try {
	
				System.out.println("Would you like to quit?  Enter 0 for yes or 1 for no: ");
				ans = scan.nextInt();

				// See if user enters invalid number
				if (ans < 0 || ans > 1) {

					System.out.println("ERROR:  Not one of the options.");
					ans = 2; // Return undefined number as answer

				} // end if

			} catch (Exception e) {

				error = scan.next();
				System.out.println("ERROR:  Invalid input.");
				ans = 2;

			}// end try-catch

		} while (ans == 2); //end do-while

		return ans;

	} // end function

	public static void main(String[] args) throws IOException {

		// Create scanner object
		Scanner myScanner = new Scanner(System.in);

		// Number of games variable
		long numGames = 0L;

		// Error trip-wire String
		String errorTripWire = "";

		// Create Dice objects
		Die diceOne = new Die();
		Die diceTwo = new Die();

		// Create answer variable for qutting
		int answer = 0;

		// Create game object
		TokenDiceGame game = new TokenDiceGame(numGames);

		// Introduce users to program
		System.out.print("Welcome to the Token Dice Game Simulator!  This program will play through a game similar through Shut the Box as many times as the user enters.  It will then print out the games the CPU plays and the results of wins/loses.  Then the program will calculate the win percentage.  The purpose is to determine the overall probability of beating the token-dice game.");

		// Main loop
		do {

			// Call function for number of games
			numGames = getNumGames(myScanner, errorTripWire);

			// Load number of games in game object
			game.numGames = numGames;

			// Proceed with main program loop
			game.play();
			
			// Call function for prompting user if they want to run program again
			answer = askForQuit(myScanner, errorTripWire);

		} while (answer != 0); // end do-while

	} // end main function

} // end TokenDiceMain class