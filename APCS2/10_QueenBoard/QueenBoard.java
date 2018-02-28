/***
* class QueenBoard
* Generates solutions for N-Queens problem.
*/

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
  * precondition: board is filled with 0's only.
  * postcondition:
  * If a solution is found, board shows position of N queens,
  * returns true.
  * If no solution, board is filled with 0's,
  * returns false.
  */
  public boolean solve()
  {
    if (_board.length < 4) {
      return false;
    }
    else {
      addQueen(1,0);
      return solveH(1);
    }
  }


  /**
  *Helper method for solve.
  */
  private boolean solveH( int col )
  {
    for (int r = 0; r < _board.length; r++) {
      if (_board[r][col] == 0) {
        addQueen(r,col);
        break;
      }
    }
    if (col == _board.length - 1) {
      printSolution();
      return true;
    }
    else {
      return solveH(col + 1);
    }
  }


  public void printSolution()
  {
    /** Print board, a la toString...
    Except:
    all negs and 0's replaced with underscore
    all 1's replaced with 'Q'
    */

    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if (_board[r][c] == 1) {
          ans += "Q\t";
        }
        else {
          ans += "_\t";
        }
      }
      ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
  * Adds a Queen to the board at position (row,col)
  * precondition: A QueenBoard has been instantiated
  * postcondition: If position (row,col) is not occupied by another queen and cannot be attacked by another queen,
  * then a 1 is added at (row,col) to represent the queen.
  * Each position in the same horizontal or diagonal to the right of the col has its value decreased by one
  */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
  * Remove a queen from position (row,col) on the board.
  * precondition: A QueenBoard has been instantiated
  * postcondition: If position (row,col) is occupied by a queen (value is equal to 1),
  * subtract 1 from position (row,col) and all other positions in the same horizontal and diagonal to the right of col.
  */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
  * toString method for the QueenBoard
  * precondition:
  * postcondition: The QueenBoard is printed out.
  */
  public String toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(1,0);
    System.out.println(b);
    b.addQueen(3,1);
    System.out.println(b);
    b.addQueen(0,2);
    System.out.println(b);
    b.addQueen(2,3);
    System.out.println(b);
    b.addQueen(4,4);
    System.out.println(b);

    QueenBoard test = new QueenBoard(8);
    test.solve();
  }

}//end class
