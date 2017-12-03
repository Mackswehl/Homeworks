// Maxwell Vale
// APCS1 pd2
// HW43 -- Array of Titanium
// 2017-11-30r

/***************************
 * class SuperArray version 3.0
 * ( SKELETON )
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * ListInt interface. (ListInt.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List
{

    private Object[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new Object[10];
	_size = 0;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of SuperArray
    private void expand()
    {
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public Object get( int index )
    {
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public Object set( int index, Object x )
    {
	Object temp = _data[index];
	_data[index] = x;
	return temp;
    }


    //adds an item after the last item
    public boolean add( Object x )
    {
	add( _size, x );
	return true;
    }


    //inserts an item at index
    public void add( int index, Object x )
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}
	_data[index] = x;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public Object remove( int index )
    {
	Object oldVal = _data[index];
	for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_size--;
	return oldVal;
    }


    //return number of meaningful items in _data
    public int size()
    {
	return _size;
    }



    //main method for testing
    public static void main( String[] args )
    {

	  List mayfield = new SuperArray();
	  System.out.println("\nPrinting empty SuperArray mayfield...");
	  System.out.println(mayfield);

	  System.out.println("\nAdding 5...");
	  System.out.println(mayfield.add(5));
	  System.out.println("Adding 4...");
	  System.out.println(mayfield.add(4));
	  System.out.println("Adding 3...");
	  System.out.println(mayfield.add(3));
	  System.out.println("Adding 2...");
	  System.out.println(mayfield.add(2));
	  System.out.println("Adding 1...");
	  System.out.println(mayfield.add(1));

	  System.out.println("\nPrinting populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.print("Removed item: ");
	  System.out.println(mayfield.remove(3));
	  System.out.println(mayfield);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.print("Removed item: ");
	  System.out.println(mayfield.remove(3));
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	/*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
    }//end main()


}//end class

/***

░░█▀░░░░░░░░░░░▀▀███████░░░░
░░█▌░░░░░░░░░░░░░░░▀██████░░░
░█▌░░░░░░░░░░░░░░░░███████▌░░
░█░░░░░░░░░░░░░░░░░████████░░
▐▌░░░░░░░░░░░░░░░░░▀██████▌░░
░▌▄███▌░░░░▀████▄░░░░▀████▌░░
▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░
▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌
▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌
▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌
░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░
░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░
░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░
░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░
░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░
░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░
░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░
░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░
░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░
▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░
░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄
░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░
░░▄▌████████▄▄▄███████▌░░░░░▄
░▄▀░██████████████████▌▀▄░░░░
▀░░░█████▀▀░░░▀███████░░░▀▄░░
░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░
░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀
░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░
░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░
░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░
░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░

***/
