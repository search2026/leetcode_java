package guess_number;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class GuessNumber {
    /*
        Guess Number
        Difficulty: Medium
     */
    public class Solution {
        String target;

        public Solution(String target) {
            this.target = target;
        }

        private int guessServer(String guess) {
            int res = 0;
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : target.toCharArray()) targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            Map<Character, Integer> guessMap = new HashMap<>();
            for (char c : guess.toCharArray()) guessMap.put(c, guessMap.getOrDefault(c, 0) + 1);
            for (char k : guessMap.keySet()) {
                if (targetMap.containsKey(k))
                    res += Math.min(guessMap.get(k), targetMap.get(k));
            }
            return res;
        }

        private String genNumber(List<Integer> guessed, int c) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < guessed.size(); i++)
                sb.append(guessed.get(i));
            for (int i = guessed.size(); i < 4; i++)
                sb.append(c);
            return sb.toString();
        }

        private String genNumber(List<Integer> guessed) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < guessed.size(); i++)
                sb.append(guessed.get(i));
            return sb.toString();
        }

        public String guess() {
            int counter = 0;
            List<Integer> res = new ArrayList<>();
            List<Integer> candList = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                candList.add(i);
            }

            Iterator<Integer> iter = candList.iterator();
            // System.out.println("\nstart to guess " + target + " ...");
            // System.out.println("res: " + res);
            // System.out.println("candList: " + candList);
            while (iter.hasNext() && res.size() < 4) {
                int cand = iter.next();
                counter++;
                int guessedCount = res.size();
                String toBeGuessed = genNumber(res, cand);
                int guessRes = guessServer(toBeGuessed);
                // System.out.println("guessedCount: " + toBeGuessed);
                // System.out.println("guessRes: " + guessRes);
                if (guessRes == guessedCount) {
                    // no luck, remove cand from candsList
                    iter.remove();
                } else if (guessRes > guessedCount) {
                    // add matched cands
                    for (int i = guessedCount; i < guessRes; i++) {
                        res.add(cand);
                    }
                    iter.remove();
                } else {
                    return genNumber(res);
                }
                // System.out.println("res: " + res);
                // System.out.println("candList: " + candList);
                if (candList.size() == 1) {
                    // early termination if only one left in candList
                    for (int i = res.size(); i < 4; i++)
                        res.add(candList.get(0));
                }
            }

            // System.out.println("guessed " + counter + " times");
            return genNumber(res);
        }
    }

    public static class UnitTest {
        @Test
        public void test() {
            String guess = "2345";
            Solution sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());

            guess = "3456";
            sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());

            guess = "4536";
            sol = new GuessNumber().new Solution(guess);
            char[] res = guess.toCharArray();
            Arrays.sort(res);
            assertEquals(new String(res), sol.guess());

            guess = "1111";
            sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());

            guess = "6666";
            sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());

            guess = "2266";
            sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());

            guess = "5566";
            sol = new GuessNumber().new Solution(guess);
            assertEquals(guess, sol.guess());
        }
    }
}

