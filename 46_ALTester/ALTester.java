import java.util.ArrayList;

public class ALTester {

  public static void populate ( ArrayList<Comparable> list ) {
    for (int i = 0; i < 23; i++) {
      list.add((int)(Math.random() * 100));
    }
  }


  public static boolean isSorted (ArrayList<Comparable> list) {
    boolean ascending = true;
    boolean descending = true;
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i).compareTo(list.get(i+1)) < 0) {
        ascending = false;
      }
      if (list.get(i).compareTo(list.get(i+1)) > 0) {
        descending = false;
      }
      if (!(ascending || descending)) {
        break;
      }
    }
    return ascending || descending;
  }


  public static void main (String[] args) {

    ArrayList<Comparable> test = new ArrayList<Comparable>();

    populate(test);
    System.out.println(test);
    System.out.println("\nIs ArrayList test sorted?");
    System.out.println(isSorted(test));

  } // end main method

} // end class ALTester
