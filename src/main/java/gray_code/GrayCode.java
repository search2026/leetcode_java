package gray_code;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < (1 << n); i++) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }

        public ArrayList<Integer> grayCodeRecursive(int n) {
            if(n==0) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(0);
                return result;
            }

            ArrayList<Integer> result = grayCodeRecursive(n-1);
            int addNumber = 1 << (n-1);
            int originalsize=result.size();

            for(int i=originalsize-1;i>=0;i--) {
                result.add(addNumber + result.get(i));
            }
            return result;
        }
    }

    public static class UnitTest {

    }
}
