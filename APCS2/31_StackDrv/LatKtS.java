/*
* Maxwell Vale
* APCS2 pd2
* HW31 -- Stack: What is it good for?
* 2018-04-11W
*/

/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

  /**********************************************************
  * precondition:  input string has length > 0
  * postcondition: returns reversed string s
  *                flip("desserts") -> "stressed"
  **********************************************************/
  public static String flip( String s )
  {
    Latkes reverse = new Latkes(s.length());
    String reversed = "";
    for (int i = 0; i < s.length(); i++) {
      reverse.push(s.substring(i,i+1));
    }
    for (int i = 0; i < s.length(); i++) {
      reversed += reverse.pop();
    }
    return reversed;
  }//end flip()


  /**********************************************************
  * precondition:  s contains only the characters {,},(,),[,]
  * postcondition: allMatched( "({}[()])" )    -> true
  *                allMatched( "([)]" )        -> false
  *                allMatched( "" )            -> true
  **********************************************************/
  public static boolean allMatched( String s )
  {
    Latkes match = new Latkes(s.length());
    System.out.println(s);
    for (int i = 0; i < s.length(); i++) {
      String c = s.substring(i,i+1);
      if (c.equals("(") || c.equals("{") || c.equals("[")) {
        match.push(c);
        System.out.println("Open: " + c);
      }
      else  {
        System.out.println("Closed: " + c);
        String open = match.pop();
        System.out.println("Popped: " + open);
        if (match.isEmpty()) {
          return false;
        }
        else if (c.equals(")") && !(open.equals("("))) {
          return false;
        }
        else if (c.equals("}") && !(open.equals("{"))) {
          return false;
        }
        else if (c.equals("]") && !(open.equals("["))) {
          return false;
        }
      }
    }
    return match.isEmpty();
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {

    System.out.println(flip("stressed")); // --> DESSERTS

    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
