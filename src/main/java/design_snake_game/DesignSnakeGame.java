package design_snake_game;

import org.junit.Test;

import java.util.*;

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

  public static class UnitTest {
    @Test
    public void test1() {
      int[][] foods = {
              {1, 2},
              {0, 1}
      };
      SnakeGame snake = new DesignSnakeGame().new SnakeGame(3, 2, foods);
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
}

