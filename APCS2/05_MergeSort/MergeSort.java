/*
* Maxwell Vale
* APCS2 pd2
* HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
* 2018-02-06
*/

/*======================================
class MergeSort
Implements mergesort on array of ints.

Summary of Algorithm:
Sort
1. Acquire array
2. Divide the deck into two separate arrays and sort those two arrays.
3. Repeat division until array becomes length 1 (aka it is sorted)
4. Continue to merge arrays until they combine back into 1

Merge
1. Create new array to hold the merged version
2. Find the smaller first element of the two arrays (if equal, then choose either)
3. Add the smaller element to merged version and remove from the original array
4. Repeat steps 2 & 3 until one of the arrays is empty
5. Add the remainder of the non-empty array to the end of the merged array

======================================*/

public class MergeSort
{
  /******************************************************
  * int[] merge(int[],int[])
  * Merges two input arrays
  * Precond:  Input arrays are sorted in ascending order
  * Postcond: Input arrays unchanged, and
  * output array sorted in ascending order.
  ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] merged = new int[a.length + b.length]; // the merged array
    int indexA = 0; // track the index of each array
    int indexB = 0;
    int indexM = 0;
    while (indexA < a.length && indexB < b.length) { // stop when all the cards of one of the decks are gone
      // find the smaller number and add to merged
      // increment the index of the array that the number came from
      if (a[indexA] < b[indexB]) {
        merged[indexM] = a[indexA];
        indexA++;
      }
      else {
        merged[indexM] = b[indexB];
        indexB++;
      }
      indexM++;
    }
    // find out which array is now "empty" and just add the rest of the other array to the end of merged
    if (indexA == a.length) {
      for (int i = indexB; i < b.length; i++) {
        merged[indexM] = b[i];
        indexM++;
      }
    }
    else {
      for (int i = indexA; i < a.length; i++) {
        merged[indexM] = a[i];
        indexM++;
      }
    }
    return merged;
  }//end merge()


  /******************************************************
  * int[] sort(int[])
  * Sorts input array using mergesort algorithm
  * Returns sorted version of input array (ascending)
  ******************************************************/
  public static int[] sort( int[] arr )
  {
    if (arr.length == 1) { // if array is only one element, it is already sorted
      return arr;
    }
    else {
      int half = arr.length / 2; // the middle index to split the array by
      int[] half1 = new int[half]; // create two arrays for the halves of the original array
      int[] half2 = new int[arr.length - half];
      for (int i = 0; i < arr.length; i++) { // add the elements of arr into the halves
        if (i < half) {
          half1[i] = arr[i];
        }
        else {
          half2[i-half] = arr[i];
        }
      }
      return merge(sort(half1), sort(half2)); // run the same merge tehnique onto the halves until they reach length 1
    }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
    a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
    System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

    int[] arr0 = {0};
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {3,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {4,3,2,1};
    int[] arr6 = {9,42,17,63,0,512,23};
    int[] arr7 = {9,42,17,63,0,9,512,23,9};

    System.out.println("\nTesting mess-with-array method...");
    printArray( arr3 );
    mess(arr3);
    printArray( arr3 );

    System.out.println("\nMerging arr1 and arr0: ");
    printArray( merge(arr1,arr0) );

    System.out.println("\nMerging arr4 and arr2: ");
    printArray( merge(arr4,arr2) );


    System.out.println("\nSorting arr4-7...");
    printArray( sort( arr4 ) );
    printArray( sort( arr5 ) );
    printArray( sort( arr6 ) );
    printArray( sort( arr7 ) );
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~

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

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
