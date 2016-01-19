package candy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Candy {
    /*
        Candy
        https://leetcode.com/problems/candy/
        Difficulty: Hard
     */
    public class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            Arrays.fill(candies, 1);
            for (int k = 1, i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = ++k;
                } else {
                    k = 1;
                }
            }
            for (int k = 1, i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], ++k);
                } else {
                    k = 1;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += candies[i];
            }
            return count;
        }
    }

    /*
        Candy
        https://leetcode.com/problems/candy/
        Difficulty: Hard
    */
    public class Solution_2 {
        public int candy(int[] ratings) {
            int minNum = 0;
            if (ratings==null || ratings.length==0) return minNum;
            int[] nums = new int[ratings.length];
            for (int k=0; k<nums.length; k++) {
                nums[k] = 1;
            }
            for (int i=1; i<nums.length; i++) {
                if (ratings[i] > ratings[i-1]) nums[i] = nums[i-1] + 1;
                else if (ratings[i] < ratings[i-1]) nums[i] = 1;
            }
            for (int i=nums.length-2; i>=0; i--) {
                if (ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]) nums[i] = nums[i+1] + 1;
            }
            for (int i=0; i<nums.length; i++) {
                minNum += nums[i];
            }
            return minNum;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Candy().new Solution();
            assertTrue(true);
        }
    }
}
