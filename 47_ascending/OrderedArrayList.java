import java.util.ArrayList;

public class OrderedArrayList {

  public static void sort(ArrayList<Comparable> list) {
    ArrayList<Comparable> temp = new ArrayList<Comparable>();
    while (list.size() > 0) {
      Comparable min = list.get(0);
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).compareTo(min) < 0) {
          min = list.get(i);
        }
      }
      temp.add(min);
      list.remove(min);
    }
    for (int i = 0; i < temp.size(); i++) {
      list.add(temp.get(i));
    }
  }

  public static void populate ( ArrayList<Comparable> list ) {
    for (int i = 0; i < 23; i++) {
      list.add((int)(Math.random() * 100));
    }
  }

  public static void main (String[] args) {
    ArrayList<Comparable> test = new ArrayList<Comparable>();
    populate(test);
    System.out.println(test);
    sort(test);
    System.out.println(test);

  } // end main method

} // end class OrderedArrayList
