import java.util.HashSet;

public class HappyNumber {

    public class Solution {
        public int[] getDigits(int n) {
            String s = String.valueOf(n);
            int[] result = new int[s.length()];
            int i = 0;

            while (n > 0) {
                int m = n % 10;
                result[i++] = m;
                n = n / 10;
            }

            return result;
        }

        public int sum(int[] arr) {
            int sum = 0;
            for (int i : arr) {
                sum = sum + i * i;
            }
            return sum;
        }

        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<Integer>();

            while (!set.contains(n)) {
                set.add(n);

                n = sum(getDigits(n));
                if (n == 1)
                    return true;
            }

            return false;
        }
    }

    public static class UnitTest {

    }
}
