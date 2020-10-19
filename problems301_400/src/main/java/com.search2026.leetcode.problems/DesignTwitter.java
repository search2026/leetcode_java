package com.search2026.leetcode.problems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

}
