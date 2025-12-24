import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

  private static class Log {

    protected int ID, timeStamp;
    protected boolean state;

    public Log(String log) {
      String[] LOG = log.split(":");
      this.ID = Integer.parseInt(LOG[0]);
      this.state = LOG[1].equals("start");
      this.timeStamp = Integer.parseInt(LOG[2]);
    }

    @Override
    public String toString() {
      return (
        "(ID: " +
        this.ID +
        ", STATE: " +
        this.state +
        ", TIMESTAMP: " +
        this.timeStamp +
        ")"
      );
    }
  }

  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Log> callStack = new Stack<>();
    int activeTimeStamp = 0;
    int times[] = new int[n];
    for (String log : logs) {
      Log activeLog = new Log(log);
      if (!callStack.isEmpty()) {
        Log top = callStack.peek();
        if (activeLog.state) times[top.ID] += (activeLog.timeStamp -
          activeTimeStamp);
        else times[top.ID] += (activeLog.timeStamp - activeTimeStamp + 1);
      }
      if (activeLog.state) {
        callStack.push(activeLog);
        activeTimeStamp = activeLog.timeStamp;
      } else {
        callStack.pop();
        activeTimeStamp = activeLog.timeStamp + 1;
      }
    }
    return times;
  }
}

public class _636_Exclusive_Time_of_Functions {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .exclusiveTime(
            2,
            Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")
          )
      )
    );
  }
}
