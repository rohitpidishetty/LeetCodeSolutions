import java.util.LinkedList;

class BrowserHistory {

  private int currIndex = 0;

  private LinkedList<String> dll;

  public BrowserHistory(String homepage) {
    dll = new LinkedList<>();
    dll.addLast(homepage);
    currIndex = 0;
  }

  public void visit(String url) {
    if (dll.size() == currIndex + 1) {
      dll.addLast(url);
      currIndex++;
    } else {
      while (dll.size() > (currIndex + 1)) dll.removeLast();
      dll.addLast(url);
      currIndex = dll.size() - 1;
    }
  }

  public String back(int steps) {
    if (currIndex - steps >= 0) {
      currIndex -= steps;
      return dll.get(currIndex);
    } else {
      currIndex = 0;
      return dll.get(0);
    }
  }

  public String forward(int steps) {
    if (currIndex + steps < dll.size()) {
      currIndex += steps;
      return dll.get(currIndex);
    } else {
      currIndex = dll.size() - 1;
      return dll.get(currIndex);
    }
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
public class _1472_Design_Browser_History {

  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
    browserHistory.back(1); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
    browserHistory.back(1); // You are in "facebook.com", move back to "google.com" return "google.com"
    browserHistory.forward(1); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
    browserHistory.forward(2); // You are in "linkedin.com", you cannot move forward any steps.
    browserHistory.back(2); // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
    browserHistory.back(7); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
  }
}
