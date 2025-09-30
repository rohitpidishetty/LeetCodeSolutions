import java.util.HashMap;
import java.util.Map;

class AllOne {

  class DLL {

    protected DLL previous;
    protected DLL next;
    protected int freq;

    protected DLL(int freq) {
      this.freq = freq;
      this.previous = null;
      this.next = null;
    }
  }

  private Map<String, DLL> hMap;
  protected DLL listObj;
  protected DLL maxPtr;

  public AllOne() {
    hMap = new HashMap<>();
    listObj = new DLL(0);
    maxPtr = new DLL(0);
  }

  public void inc(String key) {
    if (!hMap.containsKey(key)) {
      DLL dll_obj = new DLL(1);
      hMap.put(key, dll_obj);
      listObj.next = dll_obj;
      dll_obj.previous = listObj;
      maxPtr = dll_obj;
    } else {
      DLL obj = hMap.get(key);
      int freq = obj.freq;
      if (obj.next == null) {
        DLL dll_obj = new DLL(freq + 1);
        obj.next = dll_obj;
        dll_obj.previous = obj;
        maxPtr = dll_obj;
      }
      hMap.put(key, obj.next);
    }

  }

  public void dec(String key) {}

  public String getMaxKey() {
    return null;
  }

  public String getMinKey() {
    return null;
  }
}

public class _432_All_O_one_Data_Structure {

  public static void main(String[] args) {
    AllOne obj = new AllOne();
  }
}
