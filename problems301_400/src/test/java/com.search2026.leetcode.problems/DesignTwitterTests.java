package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignTwitterTests {

    @Test
    public void testSolution() {
        DesignTwitter.Twitter twitter = new DesignTwitter().new Twitter();
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
