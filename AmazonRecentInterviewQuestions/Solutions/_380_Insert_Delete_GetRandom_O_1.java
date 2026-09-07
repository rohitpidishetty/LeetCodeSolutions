import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

  private List<Integer> list;
  private Map<Integer, Integer> map;
  private int idx = 0;
  private Random rand;

  public RandomizedSet() {
    list = new ArrayList<>();
    map = new HashMap<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    list.add(val);
    map.put(val, idx++);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    int index = map.get(val);
    int size = list.size();

    int lastElement = list.get(size - 1);
    map.put(lastElement, index);
    list.set(index, lastElement);
    map.remove(val);
    list.remove(size - 1);
    idx--;
    return true;
  }

  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

public class _380_Insert_Delete_GetRandom_O_1 {

  public static void main(String[] args) {
    RandomizedSet rs = new RandomizedSet();
  }
}
