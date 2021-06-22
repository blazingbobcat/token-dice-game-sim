# token-dice-game-sim
The Token-flipping Dice Game Simulator

$ This program written in Java SDK 16.0.1

$ Throughout history, there have been tabletop games involving dice and numbered tokens or spaces, where the objective was to take away said tokens or cover up the spaces depending on the sums of the rolls of the dice.  A modern version has the copyrighted name "Shut the Box."

$ This program is a simulation of trying to play Shut The Box and determining the probability of winning the game based on the number of games played.  The CPU will run through how ever many games the user enters and determine won or lost games each time.  Shut the Box is actually for 4 players, but v1.0 of this program only has one.

$ As stated, the objective of the game is to clear all the numbered tokens based on the rolls of the dice by adding said tokens together to match what the dice show.  That means if the player runs out of tokens that can add up to the sum of the dice, he or she loses.  This may take a variable number of rolls, which the coding for the program anticipates.

$ There are 3 classes for this program as follows:

- Die.class
  -- Simply the die object for the game
  -- Has function to randomly generate a number from 1 to 6
- TokenDiceGame.class
  -- The game object for the program
  -- This contains all the inner workings of the simulation, with functions to run the main loop, prompt for number of games, go through each game, determine whether game is lost or won, tally number of lost and won games; and print out results
  -- Special functions written to prompt for number of games and whether the user wants to run the program again or not.  These check for invalid input.
  -- Again, written for one player being involved
- TokenDiceMain.class
  -- The implementation class for the simulation
  -- Creates game object, which in turn creates two Die objects to play
  -- User needs to run this class in order to run simulation.  Syntax:  java TokenDiceMain
  -- Control passed over to TokenDiceGame class

$ Future versions of the game will include 4+ players and determine which player is most likely to win.  In this case, the last player to run out of tokens wins.
