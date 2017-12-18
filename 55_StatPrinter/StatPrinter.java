// Maxwell Vale
// APCS1 pd02
// HW<hw number> - <HW NAME>
// <yyyy-mm-dd>

import java.util.ArrayList;

public class StatPrinter {

  private ArrayList<Comparable> _data = new ArrayList<Comparable>();
  private ArrayList<Comparable> freqList = new ArrayList<Comparable>();

  public int getFreq (Comparable x) {
    int freq = 0;
    for (int i = 0; i < _data.size() - 1; i++) {
      if (_data.get(i).compareTo(x) == 0) {
        freq += 1;
      }
    }
    return freq;
  }

  public Comparable max () {
    Comparable max = 0;
    for (int i = 0; i < _data.size() - 1; i++) {
      if (_data.get(i).compareTo(max) > 0) {
        max = _data.get(i);
      }
    }
    return max;
  }

  public void buildList () {
    for (int i = 0; i < max(); i++) {
      freqList.add(getFreq(i));
    }
  }

  public static void main (String[] args) {

  } // end main method

} // end class StatPrinter
