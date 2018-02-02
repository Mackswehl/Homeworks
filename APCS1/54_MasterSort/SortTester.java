//Alan Wang & Maxwell Vale (Wale)
//APCS1 pd02
//HW53 -- Solid Comparative Analysis
//2017-12-14 

import java.util.ArrayList;

public class SortTester {

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
    
    public static void main (String [] args) {
	ArrayList glen0 = new ArrayList<Integer>();
	  glen0.add(1);
	  glen0.add(2);
	  glen0.add(3);
	  glen0.add(4);
	  glen0.add(5);
	  System.out.println( "ArrayList glen before sorting:\n" + glen0 );
	  MySorts.bubbleSort(glen0);
	  System.out.println( "ArrayList glen after sorting:\n" + glen0 );
	  
	  ArrayList glen1 = new ArrayList<Integer>();
	  glen1.add(5);
	  glen1.add(4);
	  glen1.add(3);
	  glen1.add(2);
	  glen1.add(1);
	  System.out.println( "ArrayList glen before sorting:\n" + glen1 );
	  MySorts.bubbleSort(glen1);
	  System.out.println( "ArrayList glen after sorting:\n" + glen1 );

	  ArrayList coco0 = MySorts.populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco0 );
	  MySorts.bubbleSort(coco0);
	  System.out.println( "ArrayList coco after sorting:\n" + coco0 );
	  
	  /* I think the best case senario for bubbleSort is when the list 
	     is in the correct order, and the worst case senario for bubbleSort
	     is when the list is in reverse order so when the max. goes to min.
	     ; this holds true as long as it has the same # of elements. 
	  */
	  
	  ArrayList glen2 = new ArrayList<Integer>();
	  glen2.add(7);
	  glen2.add(1);
	  glen2.add(5);
	  glen2.add(12);
	  glen2.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen2 );
	  MySorts.selectionSort(glen2);
	  System.out.println( "ArrayList glen after sorting:\n" + glen2 );

	  ArrayList coco1 = MySorts.populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco1 );
	  MySorts.selectionSort(coco1);
	  System.out.println( "ArrayList coco after sorting:\n" + coco1);

	  /* I think there is no best case or worst senario for selectionSort
	     as long as they are the same amount of elements, because no matter
	     how the numbers are arranged swamping will commence either way. 
	  */
	  
	  ArrayList glen3 = new ArrayList<Integer>();
	  glen3.add(7);
	  glen3.add(1);
	  glen3.add(5);
	  glen3.add(12);
	  glen3.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen3 );
	  MySorts.insertionSort(glen3);
	  System.out.println( "ArrayList glen after sorting:\n" + glen3 );

	  ArrayList coco2 = MySorts.populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco2 );
	  MySorts.selectionSort(coco2);
	  System.out.println( "ArrayList coco after sorting:\n" + coco2);

	   /* I think there is no best case or worst senario for insertionSort
	     as long as they are the same amount of elements, because no matter
	     how the numbers are arranged swamping will commence either way. 
	  */
	  
    }
}
