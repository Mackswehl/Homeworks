// Maxwell Vale
// APCS2 pd2
// HW33 -- What a Racket
// 2018-04-13F

/*****************************************************
* class Scheme
* Simulates a rudimentary Scheme interpreter
*
* ALGORITHM for EVALUATING A SCHEME EXPRESSION:
*   1. Parse the expression into an array
*   2. Iterate through the array starting from the back
*   3. Push each element until reach an open paren.
*   4. Evaluate the expression within the parens and push the result into STACK
*   5. Repeat steps 2&3 until entire expression has been evaluated
*   6. Return the simplified value.
*
* STACK OF CHOICE: LLStack ____ by ____
* b/c I don't really have a specific reason for picking the LLStack
* over the others.
******************************************************/

public class Scheme
{
  /******************************************************
  * precond:  Assumes expr is a valid Scheme (prefix) expression,
  *           with whitespace separating all operators, parens, and
  *           integer operands.
  * postcond: Returns the simplified value of the expression, as a String
  * eg,
  *           evaluate( "( + 4 3 )" ) -> 7
  *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
  ******************************************************/
  public static String evaluate( String expr )
  {
    LLStack<String> eval = new LLStack<String>();
    String[] exprArr = expr.split("\\s+");
    for (int i = exprArr.length - 1; i >= 0; i--) {
      if (exprArr[i].equals("(")) {

        String op = eval.pop();
        if (op.equals("+")) {
          eval.push(unload(1,eval));
        }
        else if (op.equals("-")) {
          eval.push(unload(2,eval));
        }
        else {
          eval.push(unload(3,eval));
        }

      }
      else {
        eval.push(exprArr[i]);
      }
    }
    return eval.pop();
  }//end evaluate()


  /******************************************************
  * precond:  Assumes top of input stack is a number.
  * postcond: Performs op on nums until closing paren is seen thru peek().
  *           Returns the result of operating on sequence of operands.
  *           Ops: + is 1, - is 2, * is 3
  ******************************************************/
  public static String unload( int op, Stack<String> numbers ) {
    int result = Integer.parseInt(numbers.pop());
    int next;

    while (isNumber(numbers.peek())) {
      next = Integer.parseInt(numbers.pop());
      if (op == 1) {
        result += next;
      }
      else if (op == 3) {
        result *= next;
      }
      else {
        result -= next;
      }
    }
    numbers.pop();
    return "" + result;
  }//end unload()



  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }



  //main method for testing
  public static void main( String[] args )
  {


    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7

    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
    //...17

    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
    //...29

    String zoo4 = "( - 1 2 3 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
    //...-4
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
