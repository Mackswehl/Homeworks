// Maxwell Vale
// APCS1 pd02
// HW52 - Poker Face
// 2017-12-12t

/***************************************
*  class InsertionSort -- implements InsertionSort algorithm
***************************************/

import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    // start incrementing from index 1 since the first element is technically already sorted
    for (int pass = 1; pass < data.size(); pass++) {
      int index = pass; // instance var to hold pass, tracks the index of the element at index pass
      System.out.println("\nPass " + pass);
      System.out.println("Element being moved: " + data.get(pass));
      System.out.println(data); // initial state of data at beginning of pass

      while (index > 0 && data.get(index).compareTo(data.get(index - 1)) < 0) {
        Comparable small = data.get(index); // swapping the tracked element and the one before if necessary
        Comparable big = data.get(index - 1);
        data.set(index - 1, small);
        data.set(index, big);
        System.out.println(data); // print the new data with the element moved down a place
        index--; // increment index down
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
  insertionSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> copy = new ArrayList<Comparable>(); // create new ArrayList
    for (int i = 0; i < input.size(); i++) { // copy elements from input into copy so that input is not changed
      copy.add(input.get(i));
    }
    insertionSortV(copy); // sort the copy of input
    return copy; // return the copy, leaves the input unchanged
  }//end insertionSort


  public static void main( String [] args )
  {
    /*===============for VOID methods=============
    System.out.println("\n*** Testing sort-in-place (void) version... *** ");
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "\nArrayList glen before sorting:\n" + glen );
    insertionSortV(glen);
    System.out.println( "\nArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "\nArrayList coco before sorting:\n" + coco );
    insertionSortV(coco);
    System.out.println( "\nArrayList coco after sorting:\n" + coco );
    ============================================*/


    System.out.println( "*** Testing non-void version... *** " );
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "\nArrayList glen before sorting:\n" + glen );
    ArrayList glenSorted = insertionSort( glen );
    System.out.println( "\nsorted version of ArrayList glen:\n"
    + glenSorted );
    System.out.println( "\nArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "\nArrayList coco before sorting:\n" + coco );
    ArrayList cocoSorted = insertionSort( coco );
    System.out.println( "\nsorted version of ArrayList coco:\n"
    + cocoSorted );
    System.out.println( "\nArrayList coco after sorting:\n" + coco );
    /*==========for AL-returning methods==========
    ============================================*/

  }//end main

}//end class InsertionSort
