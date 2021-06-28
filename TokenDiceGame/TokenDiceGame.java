/* Token-flipping game Game class
Include java.util.* for random class
June 4, 2021 

Possible token combinations:
Roll | Tokens
-------------
2	2
3	1+2 3
4	1+3 4
5	1+4 2+3 5
6	1+5 4+2 6
7	1+6 3+4 2+5 1+2+4 7
8	1+7 2+6 3+5 1+2+5 1+3+4 8
9	1+8 2+7 3+6 4+5 1+3+5 2+3+4 1+2+6 9
10	1+9 2+8 3+7 4+6 1+2+7 1+4+5 1+3+6 2+3+5 10
11	1+10 2+9 3+8 4+7 5+6 1+2+8 1+3+7 1+4+6 2+3+6 2+4+5 11
12	1+11 2+10 3+9 4+8 5+7 1+2+9 1+3+8 1+4+7 1+5+6 2+3+7 2+4+6 3+4+5 12

*/
import java.util.*;

class TokenDiceGame {
	Scanner myScanner;
	long numGames;
	long[] winnings = {0, 0};
	boolean playing;			
	Die diceOne = new Die();
	Die diceTwo = new Die();
	int numOne;
	int numTwo;
	ArrayList<Integer> tokens;

	public TokenDiceGame(Scanner scanner, long numOfGames) {

		// User input variables
		myScanner = scanner;
		numGames = numOfGames;

		// Won/lost games array
		winnings[0] = 0;
		winnings[1] = 0;

		// Simluation boolean
		playing = false;

		// Dice numbers
		numOne = 1;
		numTwo = 1;

		// Array list for tokens
		tokens = new ArrayList<Integer>();

	} // end constructor

	public void play() {

		// Main simulation loop

		// Retreive won and lost games from simulation function
		simulation();
			
		System.out.println("Won Games: " + winnings[0]);
		System.out.println("Lost Games: " + winnings[1]);

	} // end play function

	public void simulation() {

		//System.out.println("In Simulation function!"); // DEBUG

		// Run through simulation of each game
		for (long i = 0L; i < numGames; i++) {
			// Set game running variable
			playing = true;

			// Create array list for token sums
			for (int j = 1; j < 11; j++) {
				tokens.add(j);
			} // end for loop

			//System.out.println("Tokens: " + tokens); // DEBUG

			// Main game loop
			while (playing) {
				
				//System.out.println("In playing loop!"); // DEBUG

				// Roll dice
				numOne = diceOne.Roll();
				numTwo = diceTwo.Roll();
				//System.out.println("Number One: " + numOne); // DEBUG
				//System.out.println("Number Two: " + numTwo);

				// Check if tokens match numbers on dice
				try {

					tokens.remove(numOne + numTwo);

				} catch (Exception e) {

					// Try to see if any other tokens match up 

					// Tokens are flipped.  Game is lost.
					winnings[1]++;
					playing = false;

				} finally {

					// Check for no tokens
					if (tokens.size() == 0) {

						winnings[0]++;
						playing = false;

					} // end if

				} // end try-catch clause

			} // end game loop

			tokens.clear(); // Clean out tokens list

		} // end for loop

	} // end simulation function

} // end TokenDiceGame class