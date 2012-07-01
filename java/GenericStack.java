import java.util.*;

public class GenericStack <E> {
  private E stack[];
  private int size;
  private int pointer;

  private static final int DEFAULT_STACK_SIZE = 100;

  public GenericStack () {
    this(DEFAULT_STACK_SIZE);
  }

  @SuppressWarnings("unckecked")
  public GenericStack (int size) {
    stack = (E[]) new Object[size];
    this.size = size;
    pointer = 0;
  }

  public void clear () {
    Arrays.fill(stack, 0, pointer, null);
    pointer = 0;
  }

  public void push (E x) throws Exception {
    if (pointer >= size) {
      throw new Exception("Stack overflow");
    }
    stack[pointer++] = x;
  }

  public E pop () throws Exception {
    if (pointer <= 0) {
      throw new Exception("empty!");
    }
    E value = stack[--pointer];
    stack[pointer] = null;
    return value;
  }

  public boolean isEmpty () {
    return pointer == 0;
  }

  public String toString () {
    String s = "GenericStack=[";
    for (int i = 0; i < pointer; ++i) {
      s = s + stack[i];
      if (i < pointer - 1) {
        s = s + ",";
      }
    }
    s = s + "]";
    return s;
  }

  // =======================================================

  public static void main(String args[]) {
    GenericStack stack = new GenericStack();
    try {
      stack.push("a");
      stack.push("b");
      stack.push("c");

      System.out.println(stack);
      System.out.println("pop: " + stack.pop());
      System.out.println(stack);

      stack.push("d");
      stack.push("e");
      stack.push("f");

      System.out.println(stack);
      while (!stack.isEmpty()) {
        System.out.println("pop: " + stack.pop());
      }
      System.out.println("DONE! " + stack);
    }
    catch (Exception e) {
      System.out.println("erroring?");
      System.out.println(e);
    }
  }

}
