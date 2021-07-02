# token-dice-game-sim
The Token-flipping Dice Game Simulator

$ This program written in Java SDK 16.0.1

$ Throughout history, there have been tabletop games involving dice and numbered tokens or spaces, where the objective was to take away said tokens or cover up the spaces depending on the sums of the rolls of the dice.  A modern version has the copyrighted name "Shut the Box."

$ This program is a simulation of trying to play Shut The Box and determining the probability of winning the game based on the number of games played.  The CPU will run through how ever many games the user enters and determine won or lost games each time.  Shut the Box can be played by one or many players.  The odds of winning are not different no matter the number of players.  However, some versions of the game have the object to end up with the most number of tokens flipped from the other players at the end of the game.

$ This program will only be single-player Shut the Box, where the object is to clear all the numbered tokens based on the rolls of the dice by adding said tokens together to match what the dice show.  That means if the player runs out of tokens that can add up to the sum of the dice, he or she loses.  This may take a variable number of rolls, which the coding for the program anticipates.  Ideally, the player will roll each number of unflipped tokens in succession, in which he or she will only need to flip one at a time.  That would be the perfect game.  If all the flipped tokens are more than 6, one die is used to roll the rest of the game.

$ Here are all the possible combinations for taking away tokens based on the roll of the dice:

Roll | Tokens
-------------
- 2	  2
- 3	  1+2 3
- 4	  1+3 4
- 5	  1+4 2+3 5
- 6	  1+5 4+2 6
- 7	  1+6 3+4 2+5 1+2+4 7
- 8	  1+7 2+6 3+5 1+2+5 1+3+4 8
- 9	  1+8 2+7 3+6 4+5 1+3+5 2+3+4 1+2+6 9
- 10	  1+9 2+8 3+7 4+6 1+2+7 1+4+5 1+3+6 2+3+5 10
- 11	  1+10 2+9 3+8 4+7 5+6 1+2+8 1+3+7 1+4+6 2+3+6 2+4+5 11
- 12	  1+11 2+10 3+9 4+8 5+7 1+2+9 1+3+8 1+4+7 1+5+6 2+3+7 2+4+6 3+4+5 12

$ There are 3 classes for this program as follows:

- Die.class
  -- Simply the die object for the game
  -- Has function to randomly generate a number from 1 to 6
- TokenDiceGame.class
  -- The game object for the program
  -- This contains all the inner workings of the simulation, with functions to go through each game, determine whether a game is lost or won, tally number of lost and won games; and print out results
  -- Has all variables needed to run simulation
  -- Prints out game number, roll numbers and tokens maps each game
  -- Prints out won games, lost games, and win percentage at the end of simulations
- TokenDiceMain.class
  -- The implementation class for the simulation
  -- Creates game object, which in turn creates two Die objects to play
  -- User needs to load this class in order to run simulation.
  -- Contains main loop prompting user for number of games, passing control over to TokenDiceGame class for simulations and back; and then prompting user if they want to run program again or not.

$ Version 1.0 was a prototype.  This is version 1.2 with a number of improved features:
- Elimination of god class TokenDiceGame;
- Introduction of more functions in TokenDiceMain for improved implementation
- Try-catch clauses for validation of user input
- TokenDiceGame class has constructor with all pertinent variables for simulation
- The above are version 1.1 improvements
- Game mechanics improved to check for all possible token combinations
- Game number, roll numbers and token maps added for each game
- All variables carefully chosen for data type to conserve resources (e.g. boolean for tokens)
- Win percentage added at end of simulation besides won/lost games
- Minor bug fixes

Remember to type `java TokenDiceMain` to run program.  Thank you for trying my simulation! =)
