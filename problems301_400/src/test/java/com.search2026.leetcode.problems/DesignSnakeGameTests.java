package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignSnakeGameTests {

    @Test
    public void testSolution() {
        int[][] foods = {
                {1, 2},
                {0, 1}
        };
        DesignSnakeGame.SnakeGame snake = new DesignSnakeGame().new SnakeGame(3, 2, foods);
        assertEquals(-1, snake.move("L"));
        snake = new DesignSnakeGame().new SnakeGame(3, 2, foods);
        assertEquals(0, snake.move("R"));
        assertEquals(0, snake.move("D"));
        assertEquals(1, snake.move("R"));
        assertEquals(1, snake.move("U"));
        assertEquals(2, snake.move("L"));
        assertEquals(-1, snake.move("R"));
    }

}
