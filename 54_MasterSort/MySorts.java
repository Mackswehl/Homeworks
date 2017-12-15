//Alan Wang and Maxwell Vale (Team Wale)
//APCS1 pd02
//HW54 -- One File to Bring Them All….
//2017-12-14

import java.util.ArrayList;

public class MySorts
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
  public static void bubbleSort( ArrayList<Comparable> data )
  {
    int temp = 0; //sets temp equal to 0
    int x = 0; //sets x equal to 0
    while (data.size() - 1 != x) { //does the amount of passes necessary
      for (int n = 0; data.size() - 1  > n; n++) { //switches the first & second element starting from the beginning if necessary
        if ((data.get(n).compareTo(data.get(n+1))) > 0) { //compares first & second element if first bigger than second than switch
          temp = (int) data.get(n); //sets temp equal to first element
          data.set(n, data.get(n+1)); //sets first element equal to second element
          data.set(n+1, temp); //sets second element equal to first element
        }
      }
      x += 1; //adds 1 for each pass until the while loop is satisfied
    }
  }

  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSort( ArrayList<Comparable> data )
  {
    int min; // declares min
    for (int i = 0; i < data.size() - 1; i ++){
      min = i; // initiates with the first unsorted element
      for (int j = i; j < data.size(); j ++){
        if (data.get(j).compareTo(data.get(min)) < 0){
          // set smallest to j if j is smaller
          min = j;
        }
      }
      data.set(i, data.set(min, data.get(i))); // swaps i and smallest
    }
  }//end selectionSortV

  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSort( ArrayList<Comparable> data )
  {
    int max; //initializes max
    int x; //initializes x
    for(int index = 1; index < data.size() ; index++) { //first loop (changes marker)
      x = index;
      while (x >= 0) { //Second loop (checks if max in every index)
        max = x;
        for(int ctr = x; ctr >= 0 ;ctr--) { //Third loop (finds max)
          if (data.get(ctr).compareTo(data.get(max)) > 0) {
            max = ctr;
          }
        }
        data.set( max , data.set(x , data.get(max))); //swamps the values for the max and index
        x--;
      }
    }
  }//end insertionSort

  /********** add() method **********
  * best case: O(1) - when the element being added belongs in the first index (it is smaller than every element in list)
  * This would require the least amount of time since it only needs to check with the first element of the list and nothing more
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  * worst case: O(n) - when the element being added belongs in the last position of the list (it is the greatest number in list)
  * This would require the most amount of time since the function must check with every single element (n elements) before adding it in
  **********************************/

  /********** addBin() method **********
  * best case: O(1) - when the element is equal to the middle element of the list
  * This is the fastest because if the element is equal to the middle, then after the first check the element can be inserted at that index
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  * worst case: O(log2n) - when you must complete a full binary search until the range of possible values reaches 1 or 0
  * For any number of elements, if the element being added is not equal to any of the values checked, then it splits the range of values in half log2n times
  *************************************/
}
