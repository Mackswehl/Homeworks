import java.util.ArrayList;

public class ALTester {

  public static void populate ( ArrayList list ) {
    for (int i = 0; i < 23; i++) {
      list.add((int)(Math.random() * 1000));
    }
  }

  public static void main (String[] args) {
  }

}
