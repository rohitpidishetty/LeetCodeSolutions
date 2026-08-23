import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  private Map<String, Integer> coordinateLookUps;
  private Map<Integer, String> coordinateNameLookUps;

  private int encode(String word) {
    int coordinate = 0;
    for (int i = 0; i < 3; i++) {
      coordinate <<= 8;
      coordinate |= word.charAt(i);
    }
    return coordinate;
  }

  private static class FlightStatus {

    private boolean landed;
    private int coordinate;
    private String code;

    public FlightStatus(boolean landed, int coordinate, String code) {
      this.landed = landed;
      this.coordinate = coordinate;
      this.code = code;
    }
  }

  public List<String> findItinerary(List<List<String>> tickets) {
    coordinateLookUps = new HashMap<>();
    coordinateNameLookUps = new HashMap<>();
    Map<Integer, PriorityQueue<FlightStatus>> itenerary = new HashMap<>();

    for (List<String> journey : tickets) {
      String from = journey.get(0);
      String to = journey.get(1);
      int FROM = encode(from);
      int TO = encode(to);
      if (!coordinateLookUps.containsKey(from)) {
        coordinateLookUps.put(from, FROM);
        coordinateNameLookUps.put(FROM, from);
      }
      if (!coordinateLookUps.containsKey(to)) {
        coordinateLookUps.put(to, TO);
        coordinateNameLookUps.put(TO, to);
      }
      if (!itenerary.containsKey(FROM)) {
        itenerary.put(
          FROM,
          new PriorityQueue<>((obj1, obj2) -> obj1.coordinate - obj2.coordinate)
        );
      }
      itenerary.get(FROM).add(new FlightStatus(false, TO, to));
    }
    List<String> Itenerary = new ArrayList<>();
    List<String> finalItenerary = new ArrayList<>();
    initiateJourney(itenerary, coordinateLookUps.get("JFK"), Itenerary);
    int size = Itenerary.size() - 1;
    while (size > -1) finalItenerary.add(Itenerary.get(size--));
    return finalItenerary;
  }

  private void initiateJourney(
    Map<Integer, PriorityQueue<FlightStatus>> itenerary,
    int coordinate,
    List<String> finalItenerary
  ) {
    PriorityQueue<FlightStatus> priority_queue = itenerary.get(coordinate);

    while (priority_queue != null && !priority_queue.isEmpty()) {
      FlightStatus flight = priority_queue.poll();
      initiateJourney(itenerary, flight.coordinate, finalItenerary);
    }
    finalItenerary.add(coordinateNameLookUps.get(coordinate));
  }
}

public class _332_Reconstruct_Itinerary {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findItinerary(
          Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
          )
        )
    );
  }
}
