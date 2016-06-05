package design_snake_game;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DesignSnakeGame {
    /*
        Design Snake Game
        Leetcode #353
        https://leetcode.com/discuss/questions/oj/design-snake-game?sort=votes
        http://www.cnblogs.com/grandyang/p/5558033.html
        Difficulty: Medium
     */
    public class SnakeGame {
        //Here we use int to keep the location of snake body, value = x*width + y
        //And LinkedList has the method boolean contains, to check if collide with snake body
        Deque<Integer> snakeBody = new LinkedList();
        int width = 0;
        int height = 0;
        int[][] food;
        int count = 0;
        boolean gameOver = false;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            snakeBody.addLast(0);
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            if (gameOver) return -1;
            int curValue = snakeBody.getFirst();
            int lastValue = snakeBody.removeLast();
            int[] head = new int[2];
            head[0] = curValue / width;
            head[1] = curValue % width;
            switch (direction) {
                case "U":
                    head[0]--;
                    break;
                case "L":
                    head[1]--;
                    break;
                case "R":
                    head[1]++;
                    break;
                case "D":
                    head[0]++;
                    break;
            }
            if (head[0] < 0 || head[1] < 0 || head[0] >= height || head[1] >= width || snakeBody.contains(valueOf(head))) {
                gameOver = true;
                return -1;
            }
            snakeBody.addFirst(valueOf(head));
            if (count < food.length && food[count][0] == head[0] && food[count][1] == head[1]) {
                snakeBody.addLast(lastValue);
                count++;
            }
            return snakeBody.size() - 1;
        }

        public int valueOf(int[] head) {
            return head[0] * width + head[1];
        }
    }


    /*
        Design Snake Game
        Leetcode #353
        https://leetcode.com/discuss/questions/oj/design-snake-game?sort=votes
        http://www.cnblogs.com/grandyang/p/5558033.html
        Difficulty: Medium
     */
    public class SnakeGame_2 {
        private int width, height;
        int[][] food;
        private int score, idx;
        private Deque<Integer> snake;
        private Set<Integer> body;

        public SnakeGame_2(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            score = 0;
            idx = 0;
            snake = new LinkedList<>();
            snake.addLast(0);
            body = new HashSet<>();
            body.add(0);
        }

        public int move(String direction) {
            // first of all, get head
            int h = snake.getFirst() / width, w = snake.getFirst() % width;
            if (direction.equals("U")) h--;
            else if (direction.equals("D")) h++;
            else if (direction.equals("L")) w--;
            else w++;
            if (w < 0 || w == width || h < 0 || h == height) return -1;
            int head = h*width + w;
            snake.addFirst(head); // move head
            if (idx < food.length && h == food[idx][0] && w == food[idx][1]) {
                score++; // and still keep the tail
                idx++;
            } else
                body.remove(snake.removeLast()); // move tail
            if (!body.add(head)) return -1;
            return score;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            //Solution sol = new DesignSnakeGame().new Solution();
            assertEquals(1, 1);
        }
    }
}

