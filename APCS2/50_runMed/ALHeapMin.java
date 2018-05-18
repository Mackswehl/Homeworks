//HOTDOGS -- Maxwell Vale, Tim Marder, Max Millar
//APCS2 pd2
//HW50 Run Run Run
//2018-05-18F

/*****************************************************
* class ALHeap
* SKELETON
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeapMin
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
  * default constructor  ---  inits empty heap
  *****************************************************/
  public ALHeapMin()
  {
    _heap = new ArrayList<Integer>();

  }



  /*****************************************************
  * toString()  ---  overrides inherited method
  * Returns either
  * a) a level-order traversal of the tree (simple version)
  * b) ASCII representation of the tree (more complicated, more fun)
  *****************************************************/
  public String toString()
  {

    String retStr = "";
    // Simple toString version --> gives the level-order traversal of the tree
    /*
    for (Integer i : _heap) {
    retStr += i + " ";
  }*/

  // ASCII representation of the tree
  int pow = 1; // pow to help keep track of the different tree levels
  int index = 0; // index to traverse the tree
  double x = 0; // index to keep track of last index in each level
  while (index < _heap.size()) {
    retStr += _heap.get(index) + " "; // add element to return string
    if (index == x) { // if the element is last in that level, add \n to start new level
      retStr += "\n";
      x += Math.pow(2,pow); // change x to the last index in the next level
      pow++;
    }
    index++; // increment the index
  }
  return retStr + "\n";
}//O(?)


/*****************************************************
* boolean isEmpty()
* Returns true if no meaningful elements in heap, false otherwise
*****************************************************/
public boolean isEmpty()
{
  return _heap.size() == 0;
}//O(?)


/*****************************************************
* Integer peekMin()
* Returns min value in heap
* Postcondition: Heap remains unchanged.
*****************************************************/
public Integer peekMin()
{
  // Since it is a min heap, the smallest value should always be at the top
  // So, in the ArrayList representation, the smallest value is always at index 0
  return _heap.get(0);
}//O(?)


/*****************************************************
* add(Integer)
* Inserts an element in the heap
* Postcondition: Tree exhibits heap property.
*****************************************************/
public void add( Integer addVal )
{
  int currIndex = _heap.size();
  _heap.add(addVal);
  while(_heap.get(currIndex) < _heap.get((currIndex - 1) / 2)) {
    swap(currIndex, (currIndex - 1) / 2);
    currIndex = (currIndex - 1) / 2;
  }
}//O(?)


/*****************************************************
* removeMin()  ---  means of removing an element from heap
* Removes and returns least element in heap.
* Postcondition: Tree maintains heap property.
*****************************************************/
public Integer removeMin()
{
  if (_heap.size() <= 0) {
    return -1;
  }
  else {
    swap(0,_heap.size() - 1);
    int currIndex = 0;
    int retInt = _heap.remove(_heap.size() - 1);
    while (minChildPos(currIndex) != -1 && (_heap.get(currIndex) > _heap.get(minChildPos(currIndex)))) {
      int smolChild = minChildPos(currIndex);
      swap(currIndex,smolChild);
      currIndex = smolChild;
    }
    return retInt;
  }
}//O(?)


/*****************************************************
* minChildPos(int)  ---  helper fxn for removeMin()
* Returns index of least child, or
* -1 if no children, or if input pos is not in ArrayList
* Postcondition: Tree unchanged
*****************************************************/
private int minChildPos( int pos )
{
  // If the position is out of the ArrayList or there are no children
  if (pos >= _heap.size() || 2 * pos + 1 >= _heap.size()) {
    return -1;
  }
  // If there is only a left child, just return that child
  else if (2 * pos + 2 >= _heap.size()) {
    return 2 * pos + 1;
  }
  // Otherwise, if there are two children, return the index of the smaller child
  else {
    return _heap.indexOf(minOf(_heap.get(2*pos+1), _heap.get(2*pos+2)));
  }
}//O(?)


//************ aux helper fxns ***************
private Integer minOf( Integer a, Integer b )
{
  if ( a.compareTo(b) < 0 )
  return a;
  else
  return b;
}

//swap for an ArrayList
private void swap( int pos1, int pos2 )
{
  _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
}
//********************************************

public int size() {
  return _heap.size();
}



//main method for testing
public static void main( String[] args )
{
  ALHeapMin pile = new ALHeapMin();

  System.out.println();

  pile.add(2);
  System.out.println(pile);
  pile.add(4);
  System.out.println(pile);
  pile.add(6);
  System.out.println(pile);
  pile.add(8);
  System.out.println(pile);
  pile.add(10);
  System.out.println(pile);
  pile.add(1);
  System.out.println(pile);
  pile.add(3);
  System.out.println(pile);
  pile.add(5);
  System.out.println(pile);
  pile.add(7);
  System.out.println(pile);
  pile.add(9);
  System.out.println(pile);

  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);
  /*
  System.out.println("Next smallest value: " + pile.peekMin());
  System.out.println("removing " + pile.removeMin() + "...");
  System.out.println(pile);*/
  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}//end main()

}//end class ALHeap
