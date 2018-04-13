// Maxwell Vale
// APCS2 pd2
// HW32 -- Leon Leonwood Stack
// 2018-04-12R

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

  private LinkedList<PANCAKE> _stack;
  private int _stackSize;

  public LLStack () {
    _stack = new LinkedList<PANCAKE>();
    _stackSize = 0;
  }

  public boolean isEmpty() {
    return _stack.size() == 0;
  }

  public PANCAKE peek() {
    return _stack.peek();
  }

  public PANCAKE pop() {
    _stackSize--;
    return _stack.pop();
  }

  public void push (PANCAKE x) {
    _stackSize++;
    _stack.push(x);
  }

}
