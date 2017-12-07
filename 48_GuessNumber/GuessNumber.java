// Maxwell Vale
// APCS1 pd02
// HW48 -- Keep Guessing
// 2017-12-06

import cs1.Keyboard;

public class GuessNumber {

  private int _randNum;
  private int _numGuess;
  private int _lower;
  private int _upper;
  private int _guess;

  public GuessNumber() {
    _randNum = (int)(Math.random() * 100) + 1;
    _numGuess = 0;
    _lower = 1;
    _upper = 100;
  }

public boolean win() {
  return _guess == _randNum;
}

public void takeInput() {
  _guess = cs1.Keyboard.readInt();
  while (!(_guess >= _lower && _guess <= _upper)) {
    System.out.println("\nGiven number is not in the correct range...");
    System.out.print("Please input a number from " + _lower + "-" + _upper + ": ");
    _guess = cs1.Keyboard.readInt();
  }
  _numGuess++;
}

  public void playGame() {
    System.out.println("\nWelcome to the Number Guessing Game!");
    System.out.print("\nGuess a number from " + _lower + "-" + _upper + ": ");
    takeInput();
    while (win() == false) {
      if (_guess < _randNum) {
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
