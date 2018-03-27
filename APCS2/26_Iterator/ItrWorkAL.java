/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L )
    {
      for(Integer i:L) {
        if (i == key) {
          return true;
        }
      }
      return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L )
    {
      Iterator bob = L.iterator();
      while(bob.hasNext()) {
        if (key == bob.next()) {
          return true;
        }
      }
      return false;
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L )
    {
      List<Integer> odds = new ArrayList<Integer>();
      for (Integer i:L) {
        if (i%2 != 0) {
          odds.add(i);
        }
      }
      return odds;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L )
    {
      List<Integer> odds = new ArrayList<Integer>();
      Iterator steve = L.iterator();
      while(steve.hasNext()) {
        Integer check = (Integer) steve.next();
        if(check % 2 != 0) {
          odds.add(check);
        }
      }
      return odds;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L )
    {
      Iterator it = L.iterator();
      while (it.hasNext()) {
        Integer check = (Integer) it.next();
        if (check % 2 == 0) {
          it.remove();
        }
      }
    }


    public static void main( String [] args )
    {
	//var type: List   obj type: ArrayList
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...


	// a) using a FOREACH loop
  System.out.println("Printing List L using a FOREACH loop: ");
  System.out.print("[ ");
  for(Integer i : L) {
    System.out.print(i + " ");
  }
  System.out.println("]\n");


	// b) explicitly using an iterator
  System.out.println("Printing List L using an iterator: ");
  System.out.print("[ ");
  Iterator print = L.iterator();
  while (print.hasNext()) {
    System.out.print(print.next() + " ");
  }
  System.out.println("]\n");



	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
  /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork
