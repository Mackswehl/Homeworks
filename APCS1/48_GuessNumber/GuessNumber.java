// Maxwell Vale
// APCS1 pd02
// HW48 -- Keep Guessing
// 2017-12-06

import cs1.Keyboard;

public class GuessNumber {

  // instance vars
  private int _target; // stores the number to be guessed
  private int _numGuess; // number of user's guesses
  private int _lower; // lower bound of guessing range
  private int _upper; // upper bound of guessing range
  private int _guess; // user's guess

  // default constructor
  public GuessNumber() {
    _target = (int)(Math.random() * 100) + 1; // generates random number from 1-100
    _numGuess = 0; // number of guesses is initially 0
    _lower = 1; // lower bound starts at 1
    _upper = 100; // upper bound starts at 100
  }

// checks if the user's guess matches the random number
// return true if they match, and false if they don't
public boolean win() {
  return _guess == _target; //
}

// takes input from the user
// check if the guess is between acceptable guessing range
// if not in correct range, prints message and takes input again
public void takeInput() {
  _guess = cs1.Keyboard.readInt();
  while (!(_guess >= _lower && _guess <= _upper)) {
    System.out.println("\nGiven number is not in the correct range...");
    System.out.print("Please input a number from " + _lower + "-" + _upper + ": ");
    _guess = cs1.Keyboard.readInt();
  }
  _numGuess++;
}

  // runs through the Guessing Game
  // prints message saying if guess is too high/low and prompts user for new guess
  // stops once the user guesses correctly -> prints the number of guesses
  public void playGame() {
    System.out.println("\nWelcome to the Number Guessing Game!");
    System.out.print("\nGuess a number from " + _lower + "-" + _upper + ": ");
    takeInput();
    while (win() == false) {
      if (_guess < _target) {
        _lower = _guess + 1;
        System.out.println("Too low, try again...");
      }
      else {
        _upper = _guess - 1;
        System.out.println("Too high, try again...");
      }
      System.out.print("\nGuess a number from " + _lower + "-" + _upper + ": ");
      takeInput();
    }
    System.out.println("Correct! It took " + _numGuess + " guesses.");
  }

  public static void main (String[] args) {

    GuessNumber game = new GuessNumber();
    game.playGame();

  }// end main method

}// end class GuessNumber

/***

░░█▀░░░░░░░░░░░▀▀███████░░░░
░░█▌░░░░░░░░░░░░░░░▀██████░░░
░█▌░░░░░░░░░░░░░░░░███████▌░░
░█░░░░░░░░░░░░░░░░░████████░░
▐▌░░░░░░░░░░░░░░░░░▀██████▌░░
░▌▄███▌░░░░▀████▄░░░░▀████▌░░
▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░
▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌
▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌
▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌
░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░
░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░
░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░
░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░
░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░
░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░
░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░
░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░
░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░
▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░
░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄
░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░
░░▄▌████████▄▄▄███████▌░░░░░▄
░▄▀░██████████████████▌▀▄░░░░
▀░░░█████▀▀░░░▀███████░░░▀▄░░
░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░
░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀
░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░
░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░
░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░
░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░

***/
