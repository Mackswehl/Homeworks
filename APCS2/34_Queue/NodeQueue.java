// Maxwell Vale
// APCS2 pd2
// HW34 -- The English Do Not Wait in Line
// 2018-04-13

public class NodeQueue<Quasar> implements Queue<Quasar> {

  private int _queueSize;
  private LLNode<Quasar> _head;
  private LLNode<Quasar> _tail;

  public NodeQueue () {
    _queueSize = 0;
  }

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public Quasar dequeue() {
    Quasar retVal = _head.getValue();
    _head = _head.getNext();
    _queueSize--;
    return retVal;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue (Quasar x) {

    LLNode temp = new LLNode(x,null);

    if (_queueSize == 0) {
      _head = temp;
    }

    else {
      _tail.setNext(temp);
    }

    _tail = temp;
    _queueSize++;

  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    return _queueSize == 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public Quasar peekFront() {
    return _head.getValue();
  }

  public static void main (String[] args) {

    Queue<String> queue = new NodeQueue<String>();
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

    System.out.println("Is it empty? " + queue.isEmpty());

  } // end main

} //  end NodeQueue
