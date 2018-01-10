package moving_average_from_data_stream;

import java.util.*;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovingAveragefromDataStream {
    /*
        Moving Average from Data Stream - Queue
        Leetcode #346
        https://leetcode.com/discuss/questions/oj/moving-average-from-data-stream?sort=votes
        http://www.cnblogs.com/grandyang/p/5450001.html
        Difficulty: Easy
     */
    public class MovingAverage {
        private int sum;
        private int size;
        private List<Integer> queue;

        public MovingAverage(int size) {
            this.sum = 0;
            this.size = size;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            if (queue.size() < size) {
                sum = sum + val;
            } else {
                sum = sum - queue.remove(0) + val;
            }
            queue.add(val);
            return (double)sum / queue.size();
        }
    }

    /*
        Moving Average from Data Stream - Circular Buffer
        Leetcode #346
        https://leetcode.com/discuss/questions/oj/moving-average-from-data-stream?sort=votes
        http://www.cnblogs.com/grandyang/p/5450001.html
        Difficulty: Easy
     */
    public class MovingAverage_2 {
        private int sum;
        private int pointer;
        private int[] circularBuffer;

        public MovingAverage_2(int size) {
            this.pointer = 0;
            this.sum = 0;
            this.circularBuffer = new int[size];
        }

        public double next(int val) {
            int i = pointer++ % circularBuffer.length;
            sum = sum - circularBuffer[i] + val;
            circularBuffer[i] = val;
            return (double)sum / (pointer > circularBuffer.length ? circularBuffer.length : pointer);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            MovingAverage sol = new MovingAveragefromDataStream().new MovingAverage(3);
            assertEquals(1.0, sol.next(1), 0.001);
            assertEquals(5.5, sol.next(10), 0.001);
            assertEquals(4.666, sol.next(3), 0.001);
            assertEquals(6.0, sol.next(5), 0.001);
        }

        @Test
        public void test2() {
            MovingAverage_2 sol = new MovingAveragefromDataStream().new MovingAverage_2(3);
            assertEquals(1.0, sol.next(1), 0.001);
            assertEquals(5.5, sol.next(10), 0.001);
            assertEquals(4.666, sol.next(3), 0.001);
            assertEquals(6.0, sol.next(5), 0.001);
        }
    }
}

