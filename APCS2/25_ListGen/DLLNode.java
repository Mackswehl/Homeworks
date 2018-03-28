//Maxwell Vale
//APCS2 pd2
//HW24 - On the DLL
//2018-03-26

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  //YOUR IMPLEMENTATION HERE...

  //default constructor ---> Instance vars are initialized
  public DLLNode (DLLNode previous, String value, DLLNode next) {
    _prevNode = previous;
    _cargo = value;
    _nextNode = next;
  }

  //--------------v  ACCESSORS  v--------------
  public String getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }

  public DLLNode getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------

  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo ) {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext ) {
    DLLNode foo = getNext();
    _nextNode = newNext;
    newNext.setPrev(this);
    return foo;
  }

  public DLLNode setPrev ( DLLNode newPrev ) {
    DLLNode retNode = getPrev();
    _prevNode = newPrev;
    newPrev.setNext(this);
    return retNode;
  }
  //--------------^  MUTATORS  ^--------------

  // override inherited toString
  public String toString() { return _cargo.toString(); }

}//end class DLLNode
