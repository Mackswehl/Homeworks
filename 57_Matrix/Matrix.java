// Maxwell Vale
// APCS1 pd02
// HW57 - How Deep Does the Rabbit Hole Go?
// 2017-12-19t

/***
* class Matrix -- models a square matrix
*
* BACKGROUND:
* A matrix is a rectangular array.
* Its dimensions are numRows x numColumns.
* Each element is indexed as (row,column):
*  eg,
*   for 2 x 3 matrix M:
*        -       -
*   M =  | a b c |
*        | d e f |
*        -       -
*   ... d is at position (2,1) or M[2,1]
*
* TASK:
* Implement methods below, categorize runtime of each.
* Test in main method.
***/


public class Matrix
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( )
  {
    matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a )
  {
    matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  // Runs in O(1) time
  private int size()
  {
    return matrix.length;
  }


  //return the item at the specified row & column
  // Runs in O(1) time
  private Object get( int r, int c )
  {
    return matrix[r-1][c-1];
  }


  //return true if this matrix is empty, false otherwise
  // Runs in O(n^2) time
  private boolean isEmpty()
  {
    boolean empty = true;
    for (Object[] row : matrix) {
      for (Object o : row) {
        if (o != null) {
          empty = false;
        }
      }
    }
    return empty;
  }


  //overwrite item at specified row and column with newVal
  //return old value
  // Runs in O(1) time
  private Object set( int r, int c, Object newVal )
  {
    Object oldVal = matrix[r-1][c-1];
    matrix[r-1][c-1] = newVal;
    return oldVal;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  // Runs in O(n^2) time
  public String toString()
  {
    String retStr = "";
    for (Object[] row: matrix) {
      retStr += "\n| ";
      for (Object o: row) {
        retStr += o + " ";
      }
      retStr += "|";
    }
    return retStr;
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  // runs in O(n^2) time
  public boolean equals( Object rightSide )
  {
    if (rightSide instanceof Matrix && this.size() == ((Matrix)rightSide).size() && this.matrix[0].length == ((Matrix)rightSide).matrix[0].length) {
      boolean allEqual = true;
      for (int r = 1; r < this.matrix.length; r++) {
        for (int c = 1; c < this.matrix[r].length; c++) {
          allEqual = (allEqual && (this.get(r,c) == ((Matrix)rightSide).get(r,c)));
        }
      }
      return allEqual;
    }
    return false;
  }


  //swap two columns of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  // Runs in O(n) time
  public void swapColumns( int c1, int c2  )
  {
    for (Object[] row : matrix) {
      Object temp = row[c1 - 1];
      row[c1 - 1] = row[c2 - 1];
      row[c2 - 1] = temp;
    }
  }


  //swap two rows of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  // Runs in O(1) time
  public void swapRows( int r1, int r2  )
  {
    Object[] temp = matrix[r1 - 1];
    matrix[r1 - 1] = matrix[r2 - 1];
    matrix[r2 - 1] = temp;
  }


  //main method for testing
  public static void main( String[] args )
  {

    // Default constructor test
    Matrix mat = new Matrix();
    System.out.println("Testing Default Constructor: ");
    System.out.println("Matrix mat: " + mat);
    System.out.println("Size of mat: " + mat.size());

    // Overloaded Constructor test
    Matrix rix = new Matrix(5);
    System.out.println("\nTesting constructor: ");
    System.out.println("Matrix rix: " + rix);
    System.out.println("Size of rix: " + rix.size());
    System.out.println("Is rix empty? " + rix.isEmpty());

    // Testing equals method
    System.out.println("Are mat and rix equal? " + mat.equals(rix));
    Matrix rix2 = new Matrix(5);
    rix.set(1,1,1);
    System.out.println("\nrix: " + rix);
    rix2.set(1,1,1);
    System.out.println("rix2: " + rix2);
    System.out.println("Are rix and rix2 equal? " + rix.equals(rix2));
    rix2.set(2,2,2);
    System.out.println("\nrix: " + rix);
    System.out.println("rix2: " + rix2);
    System.out.println("Are rix and rix2 equal now? " + rix.equals(rix2));

    // Create new Matrix swaps
    Matrix swaps = new Matrix(4);
    int filler = 0;
    // Populating swaps with integers
    for (int r = 0; r < swaps.size(); r++) {
      for (int c = 0; c < swaps.matrix[r].length; c++) {
        swaps.matrix[r][c] = filler;
        filler++;
      }
    }

    System.out.println("\nNew Matrix swaps: " + swaps);

    System.out.println("\nObject at (3,4): " + swaps.get(3,4));
    System.out.println("Setting Object at (3,4) to 99...");
    swaps.set(3,4,99);
    System.out.println("After changing (3,4): " + swaps);

    // Testing swapColumns method
    System.out.println("\nSwapping columns 2 and 4...");
    swaps.swapColumns(2,4);
    System.out.println(swaps);

    // Testing swapRows method
    System.out.println("\nSwapping rows 1 and 3...");
    swaps.swapRows(1,3);
    System.out.println(swaps);
  } // end main method

}//end class Matrix
