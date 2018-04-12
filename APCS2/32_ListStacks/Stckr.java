/*****************************************************
* class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
*****************************************************/

public class Stckr
{
  public static void main( String[] args )
  {
    /*Stack<String> cakes = new ALStack<String>(3);

    cakes.push("hi");
    cakes.push("ok");
    cakes.push("bye");
    System.out.println("Peeking at last: " + cakes.peek()); // bye
    System.out.println("Popped: " + cakes.pop()); // bye
    System.out.println("Peeking at last: " + cakes.peek()); // ok
    System.out.println("Is empty? " + cakes.isEmpty()); // false */


    Stack<String> cakes = new LLStack<String>();
    cakes.push("hi");
    cakes.push("ok");
    cakes.push("bye");
    System.out.println("Peeking at last: " + cakes.peek()); // bye
    System.out.println("Popped: " + cakes.pop()); // bye
    System.out.println("Peeking at last: " + cakes.peek()); // ok
    System.out.println("Is empty? " + cakes.isEmpty()); // false 


    //...

  }//end main

}//end class
