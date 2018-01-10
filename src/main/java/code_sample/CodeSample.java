package code_sample;

import org.junit.jupiter.api.Test;

import java.util.*;


public class CodeSample {
    /*
        Coding Sample
        For free style writing
     */
    public class Solution {
        public void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            List<List<Integer>> list2 = new ArrayList<>();
            List<Integer> list3 = Arrays.asList(2, 1, 1, 0);
            list.add(0);
            list.add(0, 1);
            int a = list.get(0);
            list.remove(list.size() - 1); // remove last element
            Collections.sort(list);
            Collections.sort(list, Collections.reverseOrder());
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CodeSample().new Solution();
        }
    }
}

