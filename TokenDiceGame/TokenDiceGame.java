/* Token-flipping game Game class
June 4, 2021 
*/
import java.util.*;

class TokenDiceGame {
	long numGames;
	long[] winnings = {0, 0};
	boolean match;			
	Die diceOne = new Die();
	Die diceTwo = new Die();
	int numOne;
	int numTwo;
	boolean[] tokens = {false, false, false, false, false, false, false, false, false, false, false, false};
	int sumDice;
	int sumTokens;
	double winPercentage;
	long rollNumber;

	public TokenDiceGame(long numOfGames) {

		// User input variables
		numGames = numOfGames;

		// Won/lost games array
		winnings[0] = 0;
		winnings[1] = 0;

		// The percentage of won games over lost
		winPercentage = 0d;

		// Dice numbers
		numOne = 1;
		numTwo = 1;

		/* The tokens are represented by a boolean array
		   where flipping is determined by boolean values:
		   false = down, true = flipped */

		// Sum of all flipped tokens
		sumTokens = 0;

		// Sum of dice roll
		sumDice = 0;

		// Matching tokens boolean
		match = true;

		// Number roll of dice
		rollNumber = 0L;

	} // end constructor

	public void play() {

		// Main simulation loop

		// Run through simulation of each game
		for (long i = 0L; i < numGames; i++) {
			// Reset match boolean
			match = true;

			// Reset token sum
			sumTokens = 0;

			// Reset array for tokens
			resetTokens(tokens);

			// Reset roll number
			rollNumber = 0;

			// Output game number
			System.out.println("\nGame #" + (i + 1));

			// Main game loop
			while (match) {

				rollNumber++; // increase rolls

				// If the maximum token not flipped is six,
				// reduce dice by one.
				if (sumTokens >= 57) {

					System.out.println("Tokens less than six.  One die rolling...");
					sumDice = diceOne.Roll();
	
				} else {

					numOne = diceOne.Roll();
					numTwo = diceTwo.Roll();
					sumDice = numOne + numTwo;

				} // end if
				
				System.out.println("\nRoll #" + rollNumber);
				System.out.println("Sum of Dice: " + sumDice);

				// Check if tokens match numbers on dice
				match = matchSumDiceWithTokens(tokens, sumDice, sumTokens);

				System.out.println("Tokens after flip: "); // Show which tokens are flipped and 									// which are down

				for (int b = 0; b < tokens.length; b++) {

					if (!tokens[b]) {
					
						System.out.println("Token " + (b + 1) + ": down"); 

					} else {

						System.out.println("Token " + (b + 1) + ": flipped");

					} // end if

				} // end for 

			} // end game loop

			// Game is won if maximum score for tokens
			if (sumTokens == 78) {

				winnings[0]++;

			} else {

				winnings[1]++; // Game is lost if maximum score not acheived
				
			} // end if

			// Recalculate win percentage
			winPercentage = winnings[0] / (winnings[0] + winnings[1]);

		} // end for loop
			
		System.out.println("Won Games: " + winnings[0]);
		System.out.println("Lost Games: " + winnings[1]);
		System.out.println("Win Percentage: " + winPercentage);

	} // end play function

	public static void resetTokens(boolean[] tokens) {

		int index;

		for (byte j = 0; j < tokens.length; j++) {

			tokens[j] = false;
		
		} // end for

	} // end add tokens function

	public static boolean matchSumDiceWithTokens(boolean[] tokens, int sumDice, int sumTokens) {
		
		/*

			Possible token combinations:
			Roll | Tokens
			-------------
			2	2
			3	1+2 3
			4	1+3 4
			5	1+4 2+3 5
			6	1+5 2+4 1+2+3 6
			7	1+6 2+5 3+4 1+2+4 7
			8	1+7 2+6 3+5 1+2+5 1+3+4 8
			9	1+8 2+7 3+6 4+5 1+2+6 1+3+5 2+3+4 9
			10	1+9 2+8 3+7 4+6 1+2+7 1+3+6 1+4+5 2+3+5 10
			11	1+10 2+9 3+8 4+7 5+6 1+2+8 1+3+7 1+4+6 2+3+6 2+4+5 11
			12	1+11 2+10 3+9 4+8 5+7 1+2+9 1+3+8 1+4+7 1+5+6 2+3+7 2+4+6 3+4+5 12

		*/

		switch (sumDice) {

			case 1:

				// Check if token 1 is flipped
				if (!tokens[0]) {
				
					// Flip the token if not
					tokens[0] = true;
					sumTokens += 1; // Add to the token sum

				} else {

					return false; // If out of tokens, game is over

				} // end if
				
				break;
			
			case 2:

				if (!tokens[1]) {
				
					tokens[1] = true;
					sumTokens += 2;

				} else {

					return false;

				} // end if
					
				break;

			case 3:
				
				if (!tokens[2]) {
				
					tokens[2] = true;
					sumTokens += 3;

				} else if (!tokens[0] && !tokens[1]) { 

					// Check for a case of tokens adding up to sum of dice
					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;

				} else {

					return false;

				} // end if

				break;

			case 4:

				if (!tokens[3]) {
				
					tokens[3] = true;
					sumTokens += 4;

				} else if (!tokens[0] && !tokens[2]) { 

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;

				} else {

					return false;

				} // end if

				break;

			case 5:
				
				if (!tokens[4]) {
				
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[0] && !tokens[3]) { 

					tokens[0] = true;
					sumTokens += 1;
					tokens[3] = true;
					sumTokens += 4;

				} else if (!tokens[1] && !tokens[2]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[2] = true;
					sumTokens += 3;

				} else {

					return false;

				} // end if

				break;

			case 6:
				
				if (!tokens[5]) {
				
					tokens[5] = true;
					sumTokens += 6;

				} else if (!tokens[0] && !tokens[4]) { 

					tokens[0] = true;
					sumTokens += 1;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[1] && !tokens[3]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[3] = true;
					sumTokens += 4;

				} else if (!tokens[0] && !tokens[1] && !tokens[2]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[2] = true;
					sumTokens += 3;

				} else {

					return false;

				} // end if

				break;

			case 7:
				
				if (!tokens[6]) {
				
					tokens[6] = true;
					sumTokens += 7;

				} else if (!tokens[0] && !tokens[5]) { 

					tokens[0] = true;
					sumTokens += 1;
					tokens[5] = true;
					sumTokens += 6;

				} else if (!tokens[1] && !tokens[4]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[2] && !tokens[3]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[3] = true;
					sumTokens += 4;

				} else if (!tokens[0] && !tokens[1] && !tokens[3]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[3] = true;
					sumTokens += 4;

				} else {

					return false;

				} // end if

				break;

			case 8:
				
				if (!tokens[7]) {
				
					tokens[7] = true;
					sumTokens += 8;

				} else if (!tokens[0] && !tokens[6]) { 

					tokens[0] = true;
					sumTokens += 1;
					tokens[6] = true;
					sumTokens += 7;

				} else if (!tokens[1] && !tokens[5]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[2] && !tokens[4]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[0] && !tokens[1] && !tokens[4]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[0] && !tokens[2] && !tokens[3]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;
					tokens[3] = true;
					sumTokens += 4;

				} else {

					return false;

				} // end if

				break;

			case 9:

				if (!tokens[8]) {

					tokens[8] = true;
					sumTokens += 9;
				
				} else if (!tokens[0] && !tokens[7]) {

					tokens[0] = true;
					sumTokens += 2;
					tokens[7] = true;
					sumTokens += 8;

				} else if (!tokens[1] && !tokens[6]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[5] = true;
					sumTokens += 7;

				} else if (!tokens[2] && !tokens[5]) {

					tokens[2] = true;
					sumTokens += 4;
					tokens[5] = true;
					sumTokens += 6;

				} else if (!tokens[3] && !tokens[4]) {

					tokens[3] = true;
					sumTokens += 4;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[0] && !tokens[1] && !tokens[5]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[5] = true;
					sumTokens += 6;

				} else if (!tokens[0] && !tokens[2] && !tokens[4]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;
					tokens[4] = true;
					sumTokens += 5;

				} else if (!tokens[1] && !tokens[2] && !tokens[3]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[2] = true;
					sumTokens += 3;
					tokens[3] = true;
					sumTokens += 4;

				} else { 

					return false;

				} // end if

				break;

			case 10:
				
				if (!tokens[9]) {

					tokens[9] = true;
					sumTokens += 10;

				} else if (!tokens[0] && !tokens[8]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[9] = true;
					sumTokens += 9;

				} else if (!tokens[1] && !tokens[7]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[7] = true;
					sumTokens += 8;

				} else if (!tokens[2] && !tokens[6]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[6] = true;
					sumTokens += 7;

				} else if (!tokens[3] && !tokens[5]) {

					tokens[3] = true;
					sumTokens += 4;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[0] && !tokens[1] && !tokens[6]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[6] = true;
					sumTokens += 7;
				
				} else if (!tokens[0] && !tokens[2] && !tokens[5]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[0] && !tokens[3] && !tokens[4]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[3] = true;
					sumTokens += 4;
					tokens[4] = true;
					sumTokens += 5;
				
				} else if (!tokens[1] && !tokens[2] && !tokens[4]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[2] = true;
					sumTokens += 3;
					tokens[4] = true;
					sumTokens += 4;

				} else {

					return false;

				} // end if

				break;

			case 11:
				
				if (!tokens[10]) {

					tokens[10] = true;
					sumTokens += 11;

				} else if (!tokens[0] && !tokens[9]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[9] = true;
					sumTokens += 10;

				} else if (!tokens[1] && !tokens[8]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[8] = true;
					sumTokens += 9;

				} else if (!tokens[2] && !tokens[7]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[7] = true;
					sumTokens += 8;

				} else if (!tokens[3] && !tokens[6]) {

					tokens[3] = true;
					sumTokens += 4;
					tokens[6] = true;
					sumTokens += 7;

				} else if (!tokens[4] && !tokens[5]) {

					tokens[4] = true;
					sumTokens += 5;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[0] && !tokens[1] && !tokens[7]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[7] = true;
					sumTokens += 8;
				
				} else if (!tokens[0] && !tokens[2] && !tokens[6]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;
					tokens[6] = true;
					sumTokens += 7;
				
				} else if (!tokens[0] && !tokens[3] && !tokens[5]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[3] = true;
					sumTokens += 4;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[1] && !tokens[3] && !tokens[4]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[3] = true;
					sumTokens += 4;
					tokens[4] = true;
					sumTokens += 5;

				} else {

					return false;
	
				} // end if

				break;

			case 12:
				
				if (!tokens[11]) {

					tokens[11] = true;
					sumTokens += 12;

				} else if (!tokens[0] && !tokens[10]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[10] = true;
					sumTokens += 11;

				} else if (!tokens[1] && !tokens[9]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[9] = true;
					sumTokens += 10;

				} else if (!tokens[2] && !tokens[8]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[8] = true;
					sumTokens += 9;

				} else if (!tokens[3] && !tokens[7]) {

					tokens[3] = true;
					sumTokens += 4;
					tokens[7] = true;
					sumTokens += 8;

				} else if (!tokens[4] && !tokens[6]) {

					tokens[4] = true;
					sumTokens += 5;
					tokens[6] = true;
					sumTokens += 7;
				
				} else if (!tokens[0] && !tokens[1] && !tokens[8]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[8] = true;
					sumTokens += 9;
				
				} else if (!tokens[0] && !tokens[2] && !tokens[7]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[2] = true;
					sumTokens += 3;
					tokens[7] = true;
					sumTokens += 8;
				
				} else if (!tokens[0] && !tokens[3] && !tokens[6]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[3] = true;
					sumTokens += 4;
					tokens[6] = true;
					sumTokens += 7;
				
				} else if (!tokens[0] && !tokens[4] && !tokens[5]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[4] = true;
					sumTokens += 5;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[0] && !tokens[1] && !tokens[5]) {

					tokens[0] = true;
					sumTokens += 1;
					tokens[1] = true;
					sumTokens += 2;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[1] && !tokens[2] && !tokens[6]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[2] = true;
					sumTokens += 3;
					tokens[6] = true;
					sumTokens += 7;
				
				} else if (!tokens[1] && !tokens[3] && !tokens[5]) {

					tokens[1] = true;
					sumTokens += 2;
					tokens[3] = true;
					sumTokens += 4;
					tokens[5] = true;
					sumTokens += 6;
				
				} else if (!tokens[2] && !tokens[3] && !tokens[4]) {

					tokens[2] = true;
					sumTokens += 3;
					tokens[3] = true;
					sumTokens += 4;
					tokens[4] = true;
					sumTokens += 5;

				} else {

					return false;

				} // end if

			} // end switch

		return true;

	} // end match sum dice function 

} // end TokenDiceGame class