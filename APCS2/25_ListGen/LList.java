//Maxwell Vale
//APCS2 pd2
//HW#24 -- On the DLL
//2018-03-26
/*****************************************************
* class LList
* Implements a linked list of DLLNodes, each containing T data
*****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {
    DLLNode tmp = new DLLNode( null, newVal, _head );
    _head = tmp;
    _size++;
    if (tmp.getNext() == null) { _tail = tmp }
    return true;
  }

  public void add(int i, T s){

    if ( i < 0 || i >= size() )
    throw new IndexOutOfBoundsException();

    if(i==0){
      add(s);
    }
    else if(i == _size - 1) {
      DLLNode add = new DLLNode(_tail, s, _tail.getNext());
      _tail.setNext(add);
      _tail = add;
    }
    else{
      DLLNode walk = _head;
      for(int j = 0; j < i-1; j++){
        walk = walk.getNext();
      }
      DLLNode desired = new DLLNode(walk,s,walk.getNext());
      walk.setNext(desired);
    }
    _size++;
  }

  public T remove(int i){

    if ( i < 0 || i >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode temp = _head;
    DLLNode temp2 = _tail;
    //if head node needs to be removed
    if(i==0){
      _head = temp.getNext();
      return temp.getCargo();

    }

    if(i==size - 1) {
      _tail = temp.getPrev();
      return temp2.getCargo();
    }

    //go to node at index i-1
    for(int j = 0; j < i - 1; j++){
      temp = temp.getNext();
    }
    T retVal = temp.getNext().getCargo();
    //Jump past node to be removed and set to pointer to the next node
    DLLNode next = temp.getNext().getNext();
    temp.setNext(next);
    _size--;
    return retVal;
  }

  public T get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toT
  public T toT()
  {
    T retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( T[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    james.add(3,"FIRE");
    james.add(0,"You");
    james.add(1,"and");
    System.out.println(james);

    System.out.println();

    System.out.println("Removing : " + james.remove(0));
    System.out.println(james);
    System.out.println("Removing : " + james.remove(5));
    System.out.println(james);
    System.out.println("Removing : " + james.remove(1));
    System.out.println(james);






  }

}//end class LList
