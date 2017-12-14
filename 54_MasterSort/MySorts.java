// Maxwell Vale
// APCS1 pd02
// HW<hw number> - <HW NAME>
// <yyyy-mm-dd>

import java.util.ArrayList;

public class MySorts {
    

    /**************BubbleSort**************/
    

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	int swaps = 0;
	for (int i = data.size() - 1; i > 0; i--) {
	    int n = data.get(i-1).compareTo(data.get(i)); //variable to hold result of compareTo

	    if (n > 0) { 
		Comparable x = data.get(i); // swapping the two elements when element before is greater than current element
		Comparable y = data.get(i-1);
		data.set(i,y);
		data.set(i-1,x);
		swaps++; // increase the number of sorts
	    }
	}

	if (swaps > 0) { // if nothing was swapped, data must be sorted
	    bubbleSort(data);
	}
    }
    

    /**************SelectionSort**************/
    

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSort( ArrayList<Comparable> data )
    {
	// for loop to iterate through data, changing the element at index to the smallest element in data
	for (int index = 0; index < data.size(); index++) {
	    // var holding the smallest value of data; initialized as element at index
	    Comparable min = data.get(index);
	    //for loop used to iterate through data to find the smallest element and set min equal to it
	    for (int i = index + 1; i < data.size(); i++) {
		if (data.get(i).compareTo(min) < 0) {
		    min = data.get(i);
		}
	    }
	    //Swapping the next beginning index of data to the smallest element of the remaining part of data
	    Comparable first = data.get(index); // next first element of data
	    int minIndex = data.indexOf(min); // the index of min
	    data.set(index, min); // swap min with the element at the next first index
	    data.set(minIndex, first);
	}
    }//end selectionSortV
    

    /**************BubbleSort**************/
    

    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSort( ArrayList<Comparable> data )
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

    public static void main (String[] args) {

    } // end main method

} // end class MySorts
