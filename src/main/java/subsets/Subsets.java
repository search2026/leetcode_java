package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> subsets = new ArrayList<List<Integer>>();
            for (int i = 0; i < 1 << nums.length; i++) {
                ArrayList<Integer> subset = new ArrayList<Integer>();
                int n = i;
                int idx = 0;
                while (n > 0) {
                    if ((n & 1) == 1) {
                        subset.add(nums[idx]);
                    }
                    n >>= 1;
                    idx++;
                }
                subsets.add(subset);
            }
            return subsets;
        }

        // Subsets II
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> subsets = new ArrayList<List<Integer>>();
            subsets.add(new ArrayList<Integer>());
            int last = 1;
            for (int i = 0; i < nums.length; i++) {
                int start = 0;
                if (i != 0 && nums[i] == nums[i - 1]) {
                    start = last;
                }
                last = subsets.size();
                for (int j = start; j < last; j++) {
                    ArrayList<Integer> subset = new ArrayList<Integer>(
                            subsets.get(j));
                    subset.add(nums[i]);
                    subsets.add(subset);
                }
            }
            return subsets;
        }
    }

    public static class UnitTest {

    }
}
