//Maxwell Vale
//APCS2 pd02
//HW18 -- QuickSort
//2018-03-13T

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr): Choose a point as a pivot point and move the value at that point to the end of the array.
* Iterate through the entire array and organize the values depending on whether they are smaller or larger than the value at the pivot point.
* Once the whole array has been iterated through, place the pivot point between the numbers less than it and greater than it.
* Perform a qSort on the two sides of the array.
*
* 2a. Worst pivot choice and associated runtime:
* O(n^2) -> When the pivot point is the smallest or largest value in the array. Requires an iteration through the whole array.
*
* 2b. Best pivot choice and associated runtime:
* O(nlogn) -> As long as the pivot is a value around the median value of the sorted array, the qSort method will typically run in O(nlogn) time.
*
* 3. Approach to handling duplicate values in array:
* The way that my current implementation of qSort works already seems to
* sort arrays with duplicates properly, so no other changes need to be made.
*
*****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /*****************************************************
  * void qsort(int[])
  * @param d -- array of ints to be sorted in place
  *****************************************************/
  public static void qsort( int[] d )
  {
    qsortH(d, 0, d.length - 1);
  }

  //you may need a helper method...

  //Helper Method -> qsortH
  public static void qsortH (int[] d, int left, int right) {

    if (left == right || right < left) {

    }
    else {
      int pvt = (left + right) / 2; // placing the pivot point at the center index value
      int pvtVal = d[pvt]; // value initially at the pivot point
      int wall = left; // division between the numbers less than and greater than pvtVal
      swap(pvt,right,d);

      for (int i = left; i < right; i++) {
        if (d[i] < pvtVal) {
          swap(wall,i,d);
          wall++;
        }
      }

      swap(right,wall,d);
      qsortH(d,left,wall-1);
      qsortH(d,wall+1,right);
    }
  }


  //main method for testing
  public static void main( String[] args )
  {

    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);


    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //get-it-up-and-running, static test case w/ dupes:
    //int [] arr2 = {7,1,5,12,3,7};
    //System.out.println("\narr2 init'd to: " );
    //printArr(arr2);

    //qsort( arr2 );
    //System.out.println("arr2 after qsort: " );
    //printArr(arr2);


    // arrays of randomly generated ints
    for (int size = 100000; size <= 10000000; size += 100000) {

      long totalTime = 0;
      int numTrials = 5;

      for (int trial = 1; trial <= numTrials; trial++) {

        int[] arrMatey = new int[size];
        for( int i = 0; i < arrMatey.length; i++ ) {
          arrMatey[i] = (int)( 100000 * Math.random() );
        }

        //System.out.println("\narrMatey init'd to: " );
        //printArr(arrMatey);

        shuffle(arrMatey);
        //System.out.println("arrMatey post-shuffle: " );
        //printArr(arrMatey);

        long startTime = System.currentTimeMillis();
        qsort( arrMatey );
        long endTime = System.currentTimeMillis();
        totalTime += (endTime - startTime);
        //System.out.println("arrMatey after sort: " );
        //printArr(arrMatey);

      }

      System.out.println(size + "," + totalTime/numTrials);
    }
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort

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
