import java.util.NoSuchElementException;

public class RunMed {

  private ALHeapMin lilVals;
  private ALHeapMax bigVals;

  // default constructor
  public RunMed() {

    lilVals = new ALHeapMin();
    bigVals = new ALHeapMax();

  }

  public Integer getMedian() {

    if (bigVals.isEmpty()) {
      throw new NoSuchElementException();
    }
    else if (bigVals.size() == lilVals.size()) {
      return (bigVals.peekMax() + lilVals.peekMin()) / 2;
    }
    else if (bigVals.size() > lilVals.size()) {
      return bigVals.peekMax();
    }
    else {
      return lilVals.peekMin();
    }
  }

  public void add(Integer newVal) {

    //Adding the new element to the appropriate heap
    if (bigVals.isEmpty() || newVal < bigVals.peekMax()) {
      bigVals.add(newVal);
    }
    else {
      lilVals.add(newVal);
    }

    //balancing the heaps
    while (Math.abs(bigVals.size() - lilVals.size()) > 1) {
      if (bigVals.size() > lilVals.size()) {
        lilVals.add(bigVals.removeMax());
      }
      else {
        bigVals.add(lilVals.removeMin());
      }
    }

  }

}
