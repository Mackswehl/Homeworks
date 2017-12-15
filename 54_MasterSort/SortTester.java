// Maxwell Vale
// APCS1 pd02
// HW53 - Solid Comparative Analysis
// 2017-12-13w

import java.util.ArrayList;

public class SortTester {

  public static void main (String[] args) {

    /************BubbleSort Method**************
     *  Best Case scenario: the list is already sorted
     *  Worst Case scenario: the list is put in reverse order (descending order)
     */

     ArrayList<Comparable> bestBubble = new ArrayList<Comparable>();
     for (int i = 0; i < 6; i++) {
       bestBubble.add(i);
     }
     System.out.println("bestBubble before sorting: " + bestBubble);
     System.out.println("bestBubble after sorting: " + MySorts.bubbleSort(bestBubble));
     ArrayList<Comparable> worstBubble = new ArrayList<Comparable>();
     ArrayList<Comparable> bestSelect = new ArrayList<Comparable>();
     ArrayList<Comparable> worstSelect = new ArrayList<Comparable>();
     ArrayList<Comparable> bestInsert  = new ArrayList<Comparable>();
     ArrayList<Comparable> worstInsert = new ArrayList<Comparable>();


  } // end main method

} // end class SortTester
