public interface PriorityQueue {

  //Adds an item to this priority queue.
  void add (String val);

  //Returns true if this stack is empty, otherwise returns false.
  boolean isEmpty();

  //Returns the smallest item stored in this priority queue without removing it.
  String peekMin();

  //Removes and returns the smallest item stored in this priority queue.
  String removeMin();

}
