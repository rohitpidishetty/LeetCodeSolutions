import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  private class Task {

    char task;
    int availableAt;

    Task(char task, int availableAt) {
      this.task = task;
      this.availableAt = availableAt;
    }
  }

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> freq = new HashMap<>();

    for (char task : tasks) {
      freq.put(task, freq.getOrDefault(task, 0) + 1);
    }

    PriorityQueue<Character> pq = new PriorityQueue<>(
      (a, b) -> freq.get(b) - freq.get(a)
    );

    pq.addAll(freq.keySet());

    Queue<Task> cooldown = new ArrayDeque<>();

    int time = 0;

    while (!pq.isEmpty() || !cooldown.isEmpty()) {
      while (!cooldown.isEmpty() && cooldown.peek().availableAt <= time) {
        pq.offer(cooldown.poll().task);
      }

      if (!pq.isEmpty()) {
        char task = pq.poll();
        int remaining = freq.get(task) - 1;
        freq.put(task, remaining);
        if (remaining > 0) cooldown.offer(new Task(task, time + n + 1));
      }

      time++;
    }

    return time;
  }
}

public class _621_Task_Scheduler {

  public static void main(String[] args) {
    System.out.println(
      new Solution().leastInterval(
        new char[] { 'A', 'A', 'A', 'B', 'B', 'B' },
        2
      )
    );
  }
}
