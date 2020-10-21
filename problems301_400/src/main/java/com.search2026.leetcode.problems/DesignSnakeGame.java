package com.search2026.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DesignSnakeGame {

    /*
        Design Snake Game
        Leetcode #353
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/DesignSnakeGame.md
        Difficulty: Medium
     */
    public class SnakeGame {
        private int width, height;
        int[][] food;
        private int foodIdx;
        private Deque<Integer> snake; // snake posSet list
        private Set<Integer> posSet; // snake should not touch its own posSet

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodIdx = 0;
            snake = new ArrayDeque<>();
            snake.addLast(0);
            posSet = new HashSet<>();
            posSet.add(0);
        }

        public int move(String direction) {
            // get new head's position
            int headVal = snake.getFirst();
            int h = headVal / width, w = headVal % width;
            if (direction.equals("D")) h++;
            else if (direction.equals("U")) h--;
            else if (direction.equals("R")) w++;
            else if (direction.equals("L")) w--;
            else return -1;
            if (w < 0 || w == width || h < 0 || h == height) return -1;
            headVal = h * width + w;

            // move snake's head and tail
            snake.addFirst(headVal);
            if (foodIdx < food.length && h == food[foodIdx][0] && w == food[foodIdx][1]) {
                foodIdx++; // eat food, don't remove tail
            } else {
                int tail = snake.removeLast();
                posSet.remove(tail);
            }
            // check tail after move tail
            if (posSet.contains(headVal)) return -1;
            posSet.add(headVal);
            return snake.size() - 1;
        }
    }

}
