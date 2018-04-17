/*
Team Chizza (Kyle Tau, Max Vale)
APCS2 pd2
HW35 -- Nor Do Aussies
2018-04-16
*/

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

  private ArrayList<Quasar> q = new ArrayList<Quasar>();

  /*** Runtimes for the method are based on the method used in ArrayList! ***/

  // runtime: O(n)
  public Quasar dequeue() {
    Quasar temp = q.get(0);
    q.remove(0);
    return temp;
  }

  // runtime: O(1)
  public void enqueue(Quasar x) {
    q.add(x);
  }

  // runtime: O(1)
  public boolean isEmpty() {
    return q.size() == 0;
  }

  // runtime: O(1)
  public Quasar peekFront() {
    return q.get(0);
  }

  public static void main (String[] args) {

    Queue<String> queue = new ALQueue<String>();
    queue.enqueue("hey");
    queue.enqueue("ok");
    queue.enqueue("um");
    queue.enqueue("bie");

    System.out.println("Is it empty? " + queue.isEmpty()); //False
    System.out.println("First in Line: " + queue.peekFront()); // hey
    System.out.println("First out : " + queue.dequeue()); // hey

    System.out.println("Is it empty? " + queue.isEmpty()); // False
    System.out.println("First in Line: " + queue.peekFront()); // ok
    System.out.println("First out : " + queue.dequeue()); // ok

    System.out.println("Is it empty? " + queue.isEmpty()); // False
    System.out.println("First in Line: " + queue.peekFront()); // um
    System.out.println("First out : " + queue.dequeue()); // um

    System.out.println("Is it empty? " + queue.isEmpty()); // False
    System.out.println("First in Line: " + queue.peekFront()); // bie
    System.out.println("First out : " + queue.dequeue()); // bie

    System.out.println("Is it empty? " + queue.isEmpty()); // true

  } // end main

} // end class ALQueue
