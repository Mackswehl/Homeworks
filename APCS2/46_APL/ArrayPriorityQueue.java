// Dan Gelfand and Maxwell Vale
// APCS2 pd2
// HW44 -- Arrr, There Be Priorities Here Matey
// 2018-05-10R

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

  private ArrayList<String> _queue;

  public ArrayPriorityQueue(){
    _queue = new ArrayList<String>();
  }


  //Adds an item to this priority queue.
  //O(1) --> Based on the add method of ArrayList
  public void add(String s){
    _queue.add(s);
  }

  //Returns true if this stack is empty, otherwise returns false.
  //O(1) --> Based on the isEmpty() method of ArrayList
  public boolean isEmpty(){
    return _queue.isEmpty();
  }

  //Returns the smallest item stored in this priority queue without removing it.
  //O(n) --> Iterate through the entire ArrayList once to find the smallest value
  public String peekMin(){

    //find the smallest item in the queue
    String curr = _queue.get(0);
    String min = curr;
    for(int i = 1; i < _queue.size(); i++){

      curr = _queue.get(i);

      //  System.out.println("Curr:" + curr);
      //  System.out.println("Min:" + min);
      if(curr.compareTo( min ) <= 0) {
        //update min
        min = curr;
      }
    }
    return min;
  }

  //Removes and returns the smallest item stored in this priority queue.
  //O(n) --> Finds the index of the smallest value and removes that index
  public String removeMin(){
    return _queue.remove( _queue.indexOf( peekMin() ) );
  }

  public String toString(){
    return _queue.toString();
  }

  public static void main(String[] args){

    ArrayPriorityQueue bob = new ArrayPriorityQueue();
    System.out.println("Empty? " + bob.isEmpty());
    bob.add("foo");
    bob.add("moo");

    System.out.println("Current Priority Queue: " + bob);

    System.out.println("Min: "  + bob.peekMin());
    bob.removeMin();
    System.out.println("Priority Queue After dequeue: " + bob); //[moo]

    bob.add("goo");
    bob.add("hoo");
    bob.add("doo");

    System.out.println("Current Priority Queue: " + bob);

    System.out.println("FINDING MIN... "  + bob.peekMin());
    bob.removeMin();
    System.out.println("Priority Queue After dequeue: " + bob);


  }

} //end class
