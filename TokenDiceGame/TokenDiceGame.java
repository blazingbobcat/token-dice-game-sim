/* Token-flipping game Game class
Include java.util.* for random class
June 4, 2021 */
import java.util.*;

class TokenDiceGame {

	public static void play() {

		// User input variables
		Scanner myScanner = new Scanner(System.in);
		long numGames = 0;
		byte answer = 2;

		// Won/lost games array
		long[] games = {0, 0};

		// Main simulation loop
		// obtain number of games from function
		while (numGames == 0) {

			numGames = getNumGames(myScanner);

		} // end while

		// Retreive won and lost games from simulation function
		simulation(numGames, games);
			
		System.out.println("Won Games: " + games[0]);
		System.out.println("Lost Games: " + games[1]);

		// Ask user if they want to run program again
		while (answer == 2) {

			answer = askQuit(myScanner);

		} // end while

		if (answer == 1) {

			play();  // Go back to beginning

		} // end if

	} // end play function

	public static void simulation(long numGames, long[] games) {
	
		// Simluation boolean
		boolean game = true;
					
		// Create dice objects
		Die diceOne = new Die();
		Die diceTwo = new Die();

		// Dice numbers
		int numOne = 0;
		int numTwo = 0;

		// Run through simulation of each game
		for (long i = 0; i < numGames; i++) {
			// Set game running variable
			game = true;

			// Create array list for token sums
			ArrayList<Integer> tokens = new ArrayList<Integer>();
			for (int j = 1; j < 11; j++) {
				tokens.add(j);
			} // end for loop

			//System.out.println("Tokens: " + tokens); // DEBUG

			// Main game loop
			while (game) {
				
				// Roll dice
				numOne = diceOne.Roll();
				numTwo = diceTwo.Roll();
				//System.out.println("Number One: " + numOne); // DEBUG
				//System.out.println("Number Two: " + numTwo);

				// Check if tokens match numbers on dice
				try {

					tokens.remove(numOne + numTwo);

				} catch (Exception e) {

					// Tokens are flipped.  Game is lost.
					games[1]++;
					game = false;

				} finally {

					// Check for no tokens
					if (tokens.size() == 0) {

						games[0]++;
						game = false;

					} // end if

				} // end try-catch clause

			} // end game loop

		} // end simulation

	} // end simulation function

	public static long getNumGames(Scanner scan) {

		// Use a try-catch block to get number of games, but check
		// for invalid input
		long games = 0;

		// Use an error-catching variable for Strings
		String errorTripWire;

		try {
		
			// Prompt user for number of games
			System.out.println("Please enter number of games: ");
			games = scan.nextLong();

		} catch (Exception e) {
			
			// Catch error String
			errorTripWire = scan.next();
			System.out.println("ERROR:  Invalid Input.");
			games = 0; // Return no games to game function

		} finally {
			
		
			System.out.println("games: " + games); // DEBUG

			return games;

		}// end try-catch

	} // end input number of games

	public static byte askQuit(Scanner scan) {

		byte answer = 0; // Answer for quitting
		String errorTripWire;

		// Prompt user if they want to run simulation again
		try {

			System.out.println("Would you like to quit?  Enter 0 for yes or 1 for no: ");
			answer = scan.nextByte();

		} catch (Exception e) {

			errorTripWire = scan.next();
			System.out.println("ERROR:  Invalid input.");
			answer = 2; // Return undefined number as answer

		} finally {

			System.out.println("answer: " + answer); // DEBUG
			return answer;

		}// end try-catch
	
	} // end ask quit function

} // end TokenDiceGame class