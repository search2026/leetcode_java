package com.search2026.leetcode.problems;

import java.util.*;

public class BasicCalculator {

    /*
        Basic Calculator - Recursive
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution {
        private int eval(String s, int[] p) {
            int val = 0;
            int i = p[0];
            int oper = 1; // either 1 or -1
            int num = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                switch (c) {
                    case '+':
                        val = val + oper * num;
                        num = 0;
                        oper = 1;
                        i++;
                        break;// end of number and set operator
                    case '-':
                        val = val + oper * num;
                        num = 0;
                        oper = -1;
                        i++;
                        break;// end of number and set operator
                    case '(':
                        p[0] = i + 1;
                        val = val + oper * eval(s, p);
                        i = p[0];
                        break; // start a new eval
                    case ')':
                        p[0] = i + 1;
                        return val + oper * num; // end current eval and return. Note that we need to deal with the last num
                    case ' ':
                        i++;
                        continue;
                    default:
                        num = num * 10 + c - '0';
                        i++;
                }
            }
            return val;
        }

        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            s = "(" + s + ")";
            int[] p = {0};
            return eval(s, p);
        }
    }

    /*
        Basic Calculator - Stack
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            int len = s.length(), sign = 1, res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int sum = s.charAt(i) - '0';
                    while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                        sum = sum * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    res += sum * sign;
                } else if (s.charAt(i) == '+')
                    sign = 1;
                else if (s.charAt(i) == '-')
                    sign = -1;
                else if (s.charAt(i) == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                } else if (s.charAt(i) == ')') {
                    res = res * stack.pop() + stack.pop();
                }
            }
            return res;
        }
    }

    /*
        Basic Calculator - Array
        Leetcode #224
        https://leetcode.com/problems/basic-calculator/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            int num = 0;
            int sign = 1; // either 1 or -1
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = 10 * num + (c - '0');
                } else if (c == '+') {
                    res += sign * num;
                    num = 0;
                    sign = 1;
                } else if (c == '-') {
                    res += sign * num;
                    num = 0;
                    sign = -1;
                } else if (c == '(') {
                    stack.push(res); // push previous res
                    stack.push(sign); // push sign
                    sign = 1;
                    res = 0;
                } else if (c == ')') {
                    res += sign * num;
                    num = 0;
                    res *= stack.pop();
                    res += stack.pop();
                }
            }
            if (num != 0) res += sign * num;
            return res;
        }
    }

    /*
        Basic Calculator II - Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }

            Deque<Integer> stack = new ArrayDeque<>();
            int num = 0;
            int len = s.length();
            char opr = '+';
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                    switch (opr) {
                        case '-':
                            stack.push(-num);
                            break;
                        case '+':
                            stack.push(num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    opr = s.charAt(i);
                    num = 0;
                }
            }

            int res = 0;
            for (int i : stack) {
                res += i;
            }
            return res;
        }
    }

    /*
        Basic Calculator II - Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_5 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            char opr = '+';
            for (int i = 0, num = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c))
                    num = num * 10 + (c - '0');
                if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                    if ("*/".indexOf(opr) >= 0) {
                        if (stack.isEmpty()) {
                            throw new IllegalArgumentException("input is mal-formatted");
                        }
                        res -= stack.peek();
                    }
                    switch (opr) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    num = 0;
                    opr = c;
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("input is mal-formatted");
                    }
                    res += stack.peek();
                }
            }
            return res;
        }
    }

    /*
        Basic Calculator II - No Stack
        Leetcode #227
        https://leetcode.com/problems/basic-calculator-ii/
        Difficulty: Medium
    */
    public class Solution_6 {
        public long calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }

            s = s.replaceAll(" ", "");
            int len = s.length(), i = 0;
            long res = 0;
            long prev = 0;
            char opr = '+';
            while (i < len) {
                long curr = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    curr = curr * 10 + s.charAt(i) - '0';
                    i++;
                }
                switch (opr) {
                    case '+':
                        res += prev;
                        prev = curr;
                        break;
                    case '-':
                        res += prev;
                        prev = -curr;
                        break;
                    case '*':
                        prev *= curr;
                        break;
                    case '/':
                        prev /= curr;
                        break;
                }
                if (i < len) {
                    opr = s.charAt(i);
                    i++;
                }
            }
            res += prev;
            return res;
        }
    }

    /*
        Basic Calculator III
        Leetcode #772
        https://leetcode.com/problems/basic-calculator-iii/
        Difficulty: Hard
    */
    public class Solution_7 {
        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("input can not be empty");
            }

            Deque<Integer> nums = new ArrayDeque<>();
            Deque<Character> operators = new ArrayDeque<>();
            int i = 0;
            int num = 0;
            int len = s.length();
            while (i < len) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    num = c - '0';

                    while ((i + 1) < len && Character.isDigit(s.charAt(i + 1))) {
                        num = 10 * num + s.charAt(i + 1) - '0';
                        i++;
                    }
                    nums.push(num);
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                    }
                    operators.push(c);
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                    }
                    operators.pop();
                }
                i++;
            }

            while (!operators.isEmpty()) {
                nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
            }
            return nums.isEmpty() ? 0 : nums.pop();
        }

        public boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        public int calculate(char opr, int num1, int num2) {
            int res = 0;

            switch (opr) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
            }
            return res;
        }

        // check if op2 has higher precendence than op1
        public boolean hasPrecedence(char op1, char op2) {
            if (op2 == ')' || op2 == '(') {
                return false;
            }

            return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
        }
    }

    /*
        Basic Calculator III
        Leetcode #772
        https://leetcode.com/problems/basic-calculator-iii/
        Difficulty: Hard
    */
    public class Solution_8 {
        Map<Character, Integer> precMap = new HashMap<>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }};

        public int calculate(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();

            int i = 0;
            while (i < s.length()) {
                if (Character.isDigit(s.charAt(i))) {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i++) - '0');
                    }
                    numStack.push(num);
                    i--;
                } else if (s.charAt(i) == '(') {
                    opStack.push('(');
                } else if (s.charAt(i) == ')') {
                    while (!opStack.empty() && opStack.peek() != '(') {
                        doOperation(numStack, opStack);
                    }
                    opStack.pop();
                } else if (s.charAt(i) != ' ') {
                    while (!opStack.empty() && opStack.peek() != '('
                            && precMap.get(opStack.peek()) >= precMap.get(s.charAt(i))) {
                        doOperation(numStack, opStack);
                    }
                    opStack.push(s.charAt(i));
                }
                i++;
            }

            while (!opStack.empty()) doOperation(numStack, opStack);
            return numStack.pop();
        }

        private void doOperation(Stack<Integer> numStack, Stack<Character> opStack) {
            int num2 = numStack.pop(), num1 = numStack.pop();
            char opr = opStack.pop();

            switch (opr) {
                case '+':
                    numStack.push(num1 + num2);
                    break;
                case '-':
                    numStack.push(num1 - num2);
                    break;
                case '*':
                    numStack.push(num1 * num2);
                    break;
                case '/':
                    numStack.push(num1 / num2);
                    break;
            }
        }
    }


    /*
        Basic Calculator IV
        Leetcode #770
        https://leetcode.com/problems/basic-calculator-iv//
        Difficulty: Hard
    */
    public class Solution_9 {
        int n;
        String s;
        char[] arr;
        int[] braces;
        HashMap<String, Integer> variables = new HashMap<>();

        public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
            // Initialize stuff
            s = expression;
            arr = s.toCharArray();
            n = arr.length;
            braces = new int[n];
            Arrays.fill(braces, -1);
            int[] stack = new int[n / 2];
            int index = -1;
            for (int i = 0; i < n; ++i) {
                if (arr[i] == '(') stack[++index] = i;
                else if (arr[i] == ')') {
                    int last = stack[index--];
                    braces[last] = i;
                    braces[i] = last;
                }
            }
            for (int i = 0; i < evalvars.length; ++i) variables.put(evalvars[i], evalints[i]);

            // Call the main parser which opens all brackets to the deepest levels and creates Terms
            List<Term> terms = dewIt(0, n - 1);

            // Create map to collapse and sort Terms
            TreeMap<String, Integer> map = new TreeMap<>(new Comparator<>() {
                public int compare(String a, String b) {
                    int ca = countStars(a), cb = countStars(b);
                    if (ca != cb) return cb - ca;
                    else return a.compareTo(b);
                }

                private int countStars(String s) {
                    int ans = 0;
                    for (char c : s.toCharArray()) if (c == '*') ++ans;
                    return ans;
                }
            });
            for (Term term : terms) {
                if (term.coeff != 0) {
                    String key = term.getKey();
                    if (map.containsKey(key)) {
                        int oldCoeff = map.get(key);
                        if (oldCoeff == -term.coeff) map.remove(key);
                        else map.put(key, oldCoeff + term.coeff);
                    } else map.put(key, term.coeff);
                }
            }

            // Convert map to list
            List<String> ans = new LinkedList<>();
            for (String k : map.keySet()) ans.add(map.get(k) + "" + k);
            return ans;
        }

        private List<Term> dewIt(int a, int b) {
            if (braces[a] == b) return dewIt(a + 1, b - 1);
            List<Term> ans = new LinkedList<>(), buffer = new LinkedList<>();
            buffer.add(new Term(1, new LinkedList<>()));
            for (int i = a; i <= b; ) {
                int j = i;
                List<Term> curr = null;
                if (arr[i] == '(') {
                    j = braces[i] + 1;
                    curr = dewIt(i + 1, j - 2);
                } else {
                    while (j <= b && arr[j] != ' ') ++j;
                    String exp = s.substring(i, j);
                    int val = 1;
                    List<String> vars = new LinkedList<>();
                    if (variables.containsKey(exp)) val = variables.get(exp);
                    else if (exp.charAt(0) <= '9') val = Integer.valueOf(exp);
                    else vars.add(exp);
                    curr = new LinkedList<>();
                    curr.add(new Term(val, vars));
                }
                buffer = multiply(buffer, curr);
                if (j > b || arr[j + 1] == '+' || arr[j + 1] == '-') {
                    ans.addAll(buffer);
                    buffer = new LinkedList<>();
                }
                if (j < b) {
                    ++j;
                    if (arr[j] == '+') buffer.add(new Term(1, new LinkedList<>()));
                    else if (arr[j] == '-') buffer.add(new Term(-1, new LinkedList<>()));
                    j += 2;
                }
                i = j;
            }
            return ans;
        }

        private List<Term> multiply(List<Term> a, List<Term> b) {
            List<Term> ans = new LinkedList<>();
            for (Term x : a)
                for (Term y : b) {
                    Term prod = x.clone();
                    prod.multiply(y);
                    ans.add(prod);
                }
            return ans;
        }
    }

    class Term {
        int coeff;
        List<String> vars;

        public Term(int a, List<String> c) {
            this.coeff = a;
            vars = new LinkedList<>();
            vars.addAll(c);
        }

        public String getKey() {
            StringBuilder b = new StringBuilder();
            Collections.sort(vars);
            for (String x : vars) {
                b.append('*');
                b.append(x);
            }
            return b.toString();
        }

        public void multiply(Term that) {
            this.coeff *= that.coeff;
            if (this.coeff == 0) vars.clear();
            else this.vars.addAll(that.vars);
        }

        public Term clone() {
            return new Term(coeff, vars);
        }
    }
}
