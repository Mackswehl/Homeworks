// Maxwell Vale
// APCS2 pd2
// HW51 -- Heaping Piles of Sordidness
// 2018-05-21M

import java.util.ArrayList;

public class HeapSort {

  public static void heapify (ArrayList<Integer> array) {
    for (int i = 1; i < array.size(); i++) {
      index = i;
      while (index > 0 && array.get(index) < array.get(index-1)/2) {
        swap(index, (index-1)/2);
        index = (index - 1) / 2;
      }
    }
  }

  public static void sort (ArrayList<Integer> array) {
    ALHeapMin heap = new ALHeapMin();
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    for (int i = 0; i < array.size(); i++) {
      heap.add(array.get(0));
    }
  }

  public static void main (String[] args) {

    ArrayList<Integer> al = new ArrayList<Integer>();

    al.add(10);
    al.add(8);
    al.add(6);
    al.add(4);
    al.add(2);
    al.add(1);
    al.add(3);
    al.add(5);
    al.add(7);
    al.add(9);

    System.out.println(al);

    heapify(al);
    System.out.println(al);

    sort(al);
    System.out.println(al);

  }
}
