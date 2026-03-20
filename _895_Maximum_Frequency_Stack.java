import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

  private Map<Integer, Integer> freq;
  private Map<Integer, Stack<Integer>> group;
  private int maxGroupNumber = 0;

  public FreqStack() {
    freq = new HashMap<>();
    group = new HashMap<>();
  }

  public void push(int val) {
    freq.put(val, freq.getOrDefault(val, 0) + 1);

    int groupNumber = freq.get(val);
    group.computeIfAbsent(groupNumber, e -> new Stack<>()).push(val);
    maxGroupNumber = Math.max(maxGroupNumber, groupNumber);
  }

  public int pop() {
    if (maxGroupNumber < 1) return -1;
    int ret = group.get(maxGroupNumber).pop();
    freq.put(ret, freq.get(ret) - 1);
    if (group.get(maxGroupNumber).isEmpty()) group.remove(maxGroupNumber--);
    return ret;
  }
}

public class _895_Maximum_Frequency_Stack {

  public static void main(String[] args) {
    FreqStack freqStack = new FreqStack();
    freqStack.push(4); // The stack is [5]
    freqStack.push(0); // The stack is [5,7]
    freqStack.push(9); // The stack is [5,7,5]
    freqStack.push(3); // The stack is [5,7,5,7]
    freqStack.push(4); // The stack is [5,7,5,7,4]
    freqStack.push(2); // The stack is [5,7,5,7,4,5]
    System.out.println(freqStack.pop()); // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    freqStack.push(6);
    System.out.println(freqStack.pop()); // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    freqStack.push(1);
    System.out.println(freqStack.pop()); // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    freqStack.push(4);
    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop());

    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop());
    System.out.println(freqStack.pop()); // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
  }
}
