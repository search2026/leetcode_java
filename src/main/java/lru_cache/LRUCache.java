package lru_cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*
    LRU Cache naive double linked list + hashmap approach
    https://leetcode.com/problems/lru-cache/
    Difficulty: Hard
 */
public class LRUCache {
    private HashMap<Integer, DoubleLinkedListNode> map
            = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int capacity;
//    private int len;

    public LRUCache(int capacity) {
        this.capacity = capacity;
//        len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            setHead(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
            }
        }
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.pre;
        DoubleLinkedListNode post = cur.next;

        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }

        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }

    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }

        head = node;
        if (end == null) {
            end = node;
        }
    }


    class DoubleLinkedListNode {
        public int val;
        public int key;
        public DoubleLinkedListNode pre;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode(int key, int value) {
            val = value;
            this.key = key;
        }
    }

    /*
        LRU Cache using LinkedHashMap
        https://leetcode.com/problems/lru-cache/
        Difficulty: Hard
     */
    public class LRUCacheII {
        private Map<Integer, Integer> map;
        private int capacity;

        public LRUCacheII(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity + 1);
        }

        public int get(int key) {
            Integer val = map.get(key);
            if (val == null) return -1;
            map.remove(key);
            map.put(key, val);
            return val;
        }

        public void set(int key, int value) {
            map.remove(key);
            map.put(key, value);
            if (map.size() > capacity)
                map.remove(map.entrySet().iterator().next().getKey());
        }

    }

    public static class UnitTest {
//3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
//[4,3,2,-1,-1,2,3,-1,5]

    }
}



