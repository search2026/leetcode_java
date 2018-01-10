package design_twitter;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignTwitter {
  /*
      Design Twitter
      Leetcode #355
      https://leetcode.com/problems/design-twitter/
      Difficulty: Medium
   */
  public class Twitter {
    private final int SIZE_LIMIT = 10;
    // private static class Tweet {
    private class Tweet {
      int timestamp;
      int tweetId;

      public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
      }
    }

    private Map<Integer, Set<Integer>> follow = new HashMap<>();
    private Map<Integer, Deque<Tweet>> tweets = new HashMap<>();
    private AtomicInteger timestamp;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
      timestamp = new AtomicInteger(0);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      Tweet tweet = new Tweet(tweetId, timestamp.getAndIncrement());
      tweets.putIfAbsent(userId, new ArrayDeque<Tweet>(11));
      Deque queue = tweets.get(userId);
      queue.offer(tweet);
      if (queue.size() > SIZE_LIMIT)
        queue.poll();
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> newsFeed = new ArrayList<>(SIZE_LIMIT);
      Set<Integer> followers = follow.getOrDefault(userId, new HashSet<>());
      PriorityQueue<Tweet> pq = new PriorityQueue<>(20, (x, y) -> x.timestamp - y.timestamp);
      pq.addAll(tweets.getOrDefault(userId, new ArrayDeque<Tweet>()));
      for (int follower : followers) {
        pq.addAll(tweets.getOrDefault(follower, new ArrayDeque<Tweet>()));
        while (pq.size() > SIZE_LIMIT)
          pq.poll();
      }
      while (!pq.isEmpty())
        newsFeed.add(0, pq.poll().tweetId);
      return newsFeed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      if (followerId == followeeId)
        return;
      follow.putIfAbsent(followerId, new HashSet<>());
      follow.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      if (follow.containsKey(followerId))
        follow.get(followerId).remove(followeeId);
    }
  }

  private static class Tweet {
    int timestamp;
    int tweetId;

    public Tweet(int tweetId, int timestamp) {
      this.tweetId = tweetId;
      this.timestamp = timestamp;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Twitter twitter = new DesignTwitter().new Twitter();
      // User 1 posts a new tweet (id = 5).
      twitter.postTweet(1, 5);
      // User 1's news feed should return a list with 1 tweet id -> [5].
      List<Integer> newsFeed = twitter.getNewsFeed(1);
      assertEquals(1, newsFeed.size());
      assertEquals(5, (int)newsFeed.get(0));
      // User 1 follows user 2.
      twitter.follow(1, 2);
      // User 2 posts a new tweet (id = 6).
      twitter.postTweet(2, 6);
      // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
      // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
      newsFeed = twitter.getNewsFeed(1);
      assertEquals(2, newsFeed.size());
      assertEquals(6, (int)newsFeed.get(0));
      assertEquals(5, (int)newsFeed.get(1));
      // User 1 unfollows user 2.
      twitter.unfollow(1, 2);
      // User 1's news feed should return a list with 1 tweet id -> [5],
      // since user 1 is no longer following user 2.
      newsFeed = twitter.getNewsFeed(1);
      assertEquals(1, newsFeed.size());
      assertEquals(5, (int)newsFeed.get(0));
    }
  }
}

