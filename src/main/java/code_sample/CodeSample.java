package code_sample;

import org.junit.Test;

import java.util.*;

public class CodeSample {
    /*
     */
    public class Solution {
        public void main(String[] args) {
            System.out.println("Hello World!");
            Random random = new Random();
            int randomInt = random.nextInt(100); //exclude 100
            double randomDbl = random.nextDouble();
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
            stack.offerLast(10);
            int a = stack.removeLast();

            List<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            List<List<Integer>> list2 = new ArrayList<List<Integer>>();
            List<Integer> list3 = Arrays.asList(2, 1, 1, 0);
            list.add(0);
            list.add(0, 1);
            list.get(0);
            list.remove(list.size() - 1);
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

