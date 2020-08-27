package evaluate_division;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluateDivision {
    /*
        Evaluate Division - DFS
        Leetcode #399
        https://leetcode.com/problems/evaluate-division/
        Difficulty: Hard
     */
    public class Solution {
        private double search(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
            if (set.contains(start)) return 0.0;
            if (!pairs.containsKey(start)) return 0.0;
            if (start.equals(end)) return value;
            set.add(start);

            ArrayList<String> strList = pairs.get(start);
            ArrayList<Double> valueList = values.get(start);
            double tmp = 0.0;
            for (int i = 0; i < strList.size(); i++) {
                tmp = search(strList.get(i), end, pairs, values, set, value * valueList.get(i));
                if (tmp != 0.0) {
                    break;
                }
            }
            set.remove(start);
            return tmp;
        }

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            HashMap<String, ArrayList<String>> pairs = new HashMap<>();
            HashMap<String, ArrayList<Double>> valuesPair = new HashMap<>();
            for (int i = 0; i < equations.length; i++) {
                String[] equation = equations[i];
                if (!pairs.containsKey(equation[0])) {
                    pairs.put(equation[0], new ArrayList<>());
                    valuesPair.put(equation[0], new ArrayList<>());
                }
                if (!pairs.containsKey(equation[1])) {
                    pairs.put(equation[1], new ArrayList<>());
                    valuesPair.put(equation[1], new ArrayList<>());
                }
                pairs.get(equation[0]).add(equation[1]);
                pairs.get(equation[1]).add(equation[0]);
                valuesPair.get(equation[0]).add(values[i]);
                valuesPair.get(equation[1]).add(1 / values[i]);
            }

            double[] res = new double[queries.length];
            for (int i = 0; i < queries.length; i++) {
                String[] query = queries[i];
                res[i] = search(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
                if (res[i] == 0.0) res[i] = -1.0;
            }
            return res;
        }
    }

    /*
        Evaluate Division - Union Find
        Leetcode #399
        https://leetcode.com/problems/evaluate-division/
        Difficulty: Hard
     */
    public class Solution_2 {
        // TODO: implement https://discuss.leetcode.com/topic/58577/0ms-c-union-find-solution-easy-to-understand
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, Integer> sets = new HashMap<>();
            Map<String, Double> vals = new HashMap<>();
            List<List<String>> list = new ArrayList<>();
            int nextSetNum = 0;
            for (int i = 0; i < equations.length; ++i) {
                String a = equations[i][0], b = equations[i][1];
                Integer setA = sets.get(a), setB = sets.get(b);
                if (setA == null && setB == null) {
                    sets.put(a, nextSetNum);
                    sets.put(b, nextSetNum++);
                    vals.put(a, values[i]);
                    vals.put(b, 1.0);
                    list.add(new LinkedList<>(Arrays.asList(a, b)));
                } else if (setB == null) {
                    sets.put(b, setA);
                    vals.put(b, vals.get(a) / values[i]); // not consider 0.0
                    list.get(setA).add(b);
                } else if (setA == null) {
                    sets.put(a, setB);
                    vals.put(a, vals.get(b) * values[i]);
                    list.get(setB).add(a);
                } else if (!setA.equals(setB)) {
                    double factor = vals.get(a) / values[i] / vals.get(b);
                    for (String str : list.get(setB)) {
                        sets.put(str, setA);
                        vals.put(str, vals.get(str) * factor);
                    }
                }
            }
            double[] res = new double[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                Integer setA = sets.get(queries[i][0]), setB = sets.get(queries[i][1]);
                if (setA != null && setA.equals(setB)) res[i] = vals.get(queries[i][0]) / vals.get(queries[i][1]);
                else res[i] = -1.0;
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new EvaluateDivision().new Solution();
            String[][] equations = {
                    {"a", "b"},
                    {"b", "c"}
            };
            double[] values = {2.0, 3.0};
            String[][]  queries = {
                    {"a", "c"},
                    {"b", "a"},
                    {"a", "e"},
                    {"a", "a"},
                    {"x", "x"}
            };
            double[] res = sol.calcEquation(equations, values, queries);
            assertEquals(5, res.length);
            assertEquals(6.0, res[0], 1E-03);
            assertEquals(0.5, res[1], 1E-03);
            assertEquals(-1.0, res[2], 1E-03);
            assertEquals(1.0, res[3], 1E-03);
            assertEquals(-1.0, res[4], 1E-03);
        }

        @Test
        public void test2() {
            Solution_2 sol = new EvaluateDivision().new Solution_2();
            String[][] equations = {
                    {"a", "b"},
                    {"b", "c"}
            };
            double[] values = {2.0, 3.0};
            String[][]  queries = {
                    {"a", "c"},
                    {"b", "a"},
                    {"a", "e"},
                    {"a", "a"},
                    {"x", "x"}
            };
            double[] res = sol.calcEquation(equations, values, queries);
            assertEquals(5, res.length);
            assertEquals(6.0, res[0], 1E-03);
            assertEquals(0.5, res[1], 1E-03);
            assertEquals(-1.0, res[2], 1E-03);
            assertEquals(1.0, res[3], 1E-03);
            assertEquals(-1.0, res[4], 1E-03);
        }
    }
}

