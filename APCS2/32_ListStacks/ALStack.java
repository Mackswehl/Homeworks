// Maxwell Vale
// APCS2 pd2
// HW32 -- Leon Leonwood Stack
// 2018-04-12R

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

  private ArrayList<PANCAKE> _stack;
  private int _stackSize;

  public ALStack (int size) {
    _stack = new ArrayList<PANCAKE>(size);
    _stackSize = 0;
  }

  public boolean isEmpty() {
    return _stack.isEmpty();
  }

  public PANCAKE peek() {
    return _stack.get(_stackSize - 1);
  }

  public PANCAKE pop() {
    PANCAKE retVal = _stack.remove(_stackSize - 1);
    _stackSize--;
    return retVal;
  }

  public void push (PANCAKE x) {
    _stackSize++;
    _stack.add(x);
  }

}
