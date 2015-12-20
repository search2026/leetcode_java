package permutation_sequence;

import java.util.ArrayList;

public class PermutationSequence {

    public class Solution {
        public String getPermutation(int n, int k) {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            int[] facs = new int[n + 1];
            facs[0] = 1;
            int tmp = 1;
            for (int i = 1; i <= n; i++) {
                tmp = tmp * i;
                facs[i] = tmp;
            }
            for (int i = 0; i < n; i++) {
                nums.add(i + 1);
            }
            String res = "";
            k--;
            for (int i = 0; i < n; i++) {
                int digit = 0;
                int index = k / facs[n - i - 1];
                digit = nums.remove(index);
                k = k % facs[n - i - 1];
                res = res + digit;
            }
            return res;
        }
    }

    public static class UnitTest {
    }
}
