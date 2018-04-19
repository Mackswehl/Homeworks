// Maxwell Vale
// APCS2 pd2
// HW36 --
// 2018-04-18W

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
	{
    _size = 0;
	}//end default constructor


  public void enqueue( T enQVal )
  {
    LLNode<T> temp = new LLNode<T>(enQVal,null);

    if (_size == 0) {
      _front = temp;
    }

    else {
      _end.setNext(temp);
    }

    _end = temp;
    _size++;

  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    sample(); // will randomize the front before every dequeue
    T retVal = _front.getValue();
    _front = _front.getNext();
    _size--;
    return retVal;
  }//end dequeue()


  public T peekFront()
  {
    return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * Generate a ranadom integer from[ 0,_size - 1]
   * Move the first element to the back that number of times (using enqueue/dequeue)
   * This essentially randomizes the queue by changing which of the elements is _front
   ******************************************/
  public void sample()
  {
    int n = (int) (Math.random() * _size);
    for (int i = 0; i < n; i++) { // got stack overflow from calling sample in its own function
      T retVal = _front.getValue(); // not sure if this is the way to go, but I just rewrote dequeue essentially
      _front = _front.getNext();
      _size--;
      enqueue(retVal);
    }
  }//end sample()


  public boolean isEmpty()
  {
    return _size == 0;
  } //O(1)


    // print each node, separated by spaces
  public String toString()
  {
    String retStr = "";
    LLNode node = _front;
    for (int i = 0; i < _size; i++) {
      retStr = retStr + node.getValue() + " ";
      node = node.getNext();
    }
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {


      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing...");
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");


      System.out.println("\nnow testing toString()...");
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing...");
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue...");
      System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
