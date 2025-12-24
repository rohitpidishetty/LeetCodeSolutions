import java.util.*;

class Twitter {

  private static int timestamp = 0; // global timestamp

  private static class Tweet {

    int id;
    int time;

    Tweet(int id, int time) {
      this.id = id;
      this.time = time;
    }
  }

  private Map<Integer, Set<Integer>> followees;
  private Map<Integer, List<Tweet>> tweets;

  public Twitter() {
    followees = new HashMap<>();
    tweets = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    tweets.putIfAbsent(userId, new ArrayList<>());
    tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    follow(userId, userId); // user follows themselves
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> feed = new ArrayList<>();
    if (!followees.containsKey(userId)) return feed;

    PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

    for (int uid : followees.get(userId)) {
      List<Tweet> tList = tweets.get(uid);
      if (tList != null) pq.addAll(tList);
    }

    int count = 0;
    while (!pq.isEmpty() && count < 10) {
      feed.add(pq.poll().id);
      count++;
    }

    return feed;
  }

  public void follow(int followerId, int followeeId) {
    followees.putIfAbsent(followerId, new HashSet<>());
    followees.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (followees.containsKey(followerId) && followerId != followeeId) {
      followees.get(followerId).remove(followeeId);
    }
  }
}

public class _355_Design_Twitter {

  public static void main(String[] args) {}
}
