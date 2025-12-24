import java.util.*;

class Solution {

  public int leastInterval(char[] tasks, int n) {
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    int[] job_freq = new int[26];
    int count = 0;
    for (char ch : tasks) job_freq[ch - 'A']++;
    for (int i = 0; i < 26; i++) {
      int val = job_freq[i];
      if (val > 0) pQ.offer(val);
    }
    while (!pQ.isEmpty()) {
      int job = pQ.poll();
      Stack<Integer> buffer = new Stack<>();
      if (job - 1 > 0) buffer.push(job - 1);
      int next_slots = n;
      while (!pQ.isEmpty() && next_slots > 0) {
        int curr = pQ.poll() - 1;
        if (curr > 0) buffer.push(curr);
        next_slots--;
      }
      while (!buffer.isEmpty()) pQ.offer(buffer.pop());
      if (!pQ.isEmpty()) count += (n + 1);
      else count += (n - next_slots) + 1;
    }
    return count;
  }
}

public class _621_Task_Scheduler {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3)
    );
  }
}
