package jump_game;

public class JumpGame {

    public class Solution {
        public boolean canJump(int[] nums) {
            assert nums != null;
            int far = 0;
            for (int i = 0; i < nums.length && i <= far; i++) {
                far = Math.max(far, nums[i] + i);
            }
            return far >= nums.length - 1;
        }

        // Jump Game II
        public int jump(int[] nums) {
            int step = 0;
            int next = 0;
            int current = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > current) {
                    current = next;
                    step++;
                }
                next = Math.max(next, i + nums[i]);
            }
            return step;
        }
    }

    public static class UnitTest {

    }
}
