// Maxwell Vale
// APCS2 pd02
// HW07 - A Man, A Plan, A Canal: Panama!
// <2018-02-13>

import java.util.ArrayList;

public class Resrever {

  //reverse method
  //O(n) run time
  //Utilizes a single for loop that runs through the argument string once
  public static String reverseN ( String s ) {

    String reversed = "";
    for (int i = s.length(); i > 0; i--) { // for loops runs through entire string once
      reversed += s.substring(i-1,i);
    }

    return reversed;
  }


  //reverse method
  //O(log2(n)) run time
  //Much like the merge sort algorithm, this method works by dividing the string until you get Strings of length 1
  //Dividing the String to Strings of length 1 takes O(log2(n)) time
  //Then, all that's left to be done is concatenate the Strings in reverse order
  //Since the addition is constant time, the resulting run time stays at O(log2(n))
  public static String reverseLog ( String s ) {

    if (s.length() == 1) { //If length 1, done splitting.
      return s;
    }
    else {
      int half = s.length() / 2; //Placeholder for halfway mark
      String half1 = s.substring(0,half); //Creating String for each half of the original String
      String half2 = s.substring(half);
      return (reverseLog(half2) + reverseLog(half1)); //Continue to divide and add in reverse order
    }

  }

  public static void main (String[] args) {

    System.out.println(reverseN("stressed"));
    System.out.println(reverseN("desserts"));

    System.out.println(reverseLog("stressed"));

  } // end main method

/*
  ___________((_____))
  ____________))___((
  ___________((_____))
  ____________))___((
  ___________((_____))____________$$$$$$
  ____________))___((____________$$____$$
  _$$$$$$$$$$$$$$$$$$$$$$$$$$$$$______$$
  __$$$$$$$$$$$$$$$$$$$$$$$$$$$_______$$
  ___$$$$$$$$$$$$$$$$$$$$$$$$________$$
  ____$$$$$$$$$$$$$$$$$$$$$$________$$
  ____$$$$$$$$$$$$$$$$$$$$$$______$$
  _____$$$$$$$$$$$$$$$$$$$$_____$$
  _____$$$$$$$$$$$$$$$$$$$$$$$$$
  ______$$$$$$$$$$$$$$$$$$
  _______$$$$$$$$$$$$$$$$
  _________$$$$$$$$$$$$
  ___________$$$$$$$$
  _$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  ___$$$$$$$$$$$$$$$$$$$$$$$$
  _____$$$$$$$$$$$$$$$$$$$$__
  */

} // end class Resrever
