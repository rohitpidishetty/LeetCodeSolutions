import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _126 {
  static class Binder {
    int depth;
    String node;

    public Binder(String node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public static void main(String[] args) {
    Map<String, List<String>> graph = new LinkedHashMap<>() {
      {
        put("hit", Arrays.asList("hot"));
        put("hot", Arrays.asList("dot", "lot"));
        put("dot", Arrays.asList("hot", "lot", "dog"));
        put("lot", Arrays.asList("hot", "dot", "log"));
        put("dog", Arrays.asList("dot", "log", "cog"));
        put("log", Arrays.asList("lot", "dog", "cog"));
      }
    };

    Map<String, List<String>> forwardGraph = new LinkedHashMap<>();
    // System.out.println(graph);

    Map<String, Integer> visited = new HashMap<>();

    // BFS

    Queue<Binder> q = new ArrayDeque<>();
    q.offer(new _126.Binder("hit", 1));
    visited.put("hit", 1);
    while (!q.isEmpty()) {
      Binder bpayload = q.poll();
      if (!forwardGraph.containsKey(bpayload.node))
        forwardGraph.put(bpayload.node, new ArrayList<>());
      List<String> neigbhors = graph.get(bpayload.node);
      if (neigbhors == null)
        continue;
      for (String n : neigbhors) {
        if (!visited.containsKey(n)) {
          forwardGraph.get(bpayload.node).add(n);
          q.offer(new _126.Binder(n, bpayload.depth + 1));
          visited.put(n, bpayload.depth + 1);
        } else if (visited.get(n) == bpayload.depth + 1)
          forwardGraph.get(bpayload.node).add(n);
      }
    }

    // DFS

    List<List<String>> ret = new ArrayList<>();
    dfs(forwardGraph, "hit", ret, new ArrayList<>());
    System.out.println(ret);

  }

  private static void dfs(Map<String, List<String>> fg, String level, List<List<String>> ret, List<String> buffer) {
    if (level.equals("cog")) {
      ret.add(new ArrayList<>(buffer));
      return;
    }
    buffer.add(level);
    for (String node : fg.get(level)) {
      dfs(fg, node, ret, buffer);
    }
    buffer.removeLast();
  }

}
