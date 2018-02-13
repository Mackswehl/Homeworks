// Maxwell Vale
// APCS2 pd02
// HW<hw number> - <HW NAME>
// <yyyy-mm-dd>

import java.util.ArrayList;

public class Resrever {

  public static String reverseN ( String s ) {

    String reversed = "";
    for (int i = s.length(); i > 0; i--) {
      reversed += s.substring(i-1,i);
    }

    return reversed;

  }

  public static void main (String[] args) {

    System.out.println(reverseN("stressed"));
    System.out.println(reverseN("desserts"));

  } // end main method

} // end class className
