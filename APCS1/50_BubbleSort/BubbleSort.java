// Maxwell Vale
// APCS1 pd02
// HW50 - Dat Bubbly Tho
// 2017-12-08

/******************************
* class BubbleSort -- implements bubblesort algorithm (vanilla)
******************************/

import java.util.ArrayList;

// VOID version of bubbleSort
// Rearranges elements of input ArrayList
// postcondition: data's elements sorted in ascending order
public static void bubbleSortV( ArrayList<Comparable> data )
{
  //make n-1 passes across collection
  for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
    System.out.println( "commencing pass #" + passCtr + "..." );

    //iterate from first to next-to-last element
    for( int i = 0; i < data.size()-1; i++ ) {
      //if element at i > element at i+1, swap
      if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
        data.set( i, data.set(i+1,data.get(i)) );
      //System.out.println(data); //diag: show current state of list
    }
  }
}

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    int swaps = 0;
    for (int i = data.size() - 1; i > 0; i--) {
      int n = data.get(i-1).compareTo(data.get(i)); //variable to hold result of compareTo

      if (n > 0) { // if element to the left is greater than element to the right
        Comparable x = data.get(i); // swapping the two elements
        Comparable y = data.get(i-1);
        data.set(i,y);
        data.set(i-1,x);
        swaps++; // increase the number of sorts
      }
    }

    if (swaps > 0) { // if nothing was swapped, that means that data must be sorted
      bubbleSortV(data);
    }

  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> sorted = new ArrayList<Comparable>(); // initialize a new ArrayList
    for (int i = 0; i < input.size(); i++) {
      sorted.add(input.get(i)); // copy contents of input into new ArrayList
    }
    bubbleSortV(sorted); // sort new ArrayList using bubbleSortV
    return sorted; // return new ArrayList, leave input unchanged
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    bubbleSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    bubbleSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );

    ============================================*/


    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    ArrayList glenSorted = bubbleSort( glen );
    System.out.println( "sorted version of ArrayList glen:\n"
    + glenSorted );
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    ArrayList cocoSorted = bubbleSort( coco );
    System.out.println( "sorted version of ArrayList coco:\n"
    + cocoSorted );
    System.out.println( "ArrayList coco after sorting:\n" + coco );
    /*==========for AL-returning methods==========
    ============================================*/

  }//end main

}//end class BubbleSort
