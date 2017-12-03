/***************************
 * interface ListInt
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an int to the end. Return true.
  boolean add( Object x );

  // Insert an int at index
  void add( int index, Object x );

  // Retrieve the int at index
  Object get( int index );

  // Overwrite the int at index
  int set( int index, Object x );

  // Remove the int at index,
  // shifting any elements after it to the left.
  // Return removed value.
  int remove( int index );

}//end interface List
