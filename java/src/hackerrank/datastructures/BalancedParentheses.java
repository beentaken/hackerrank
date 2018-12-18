package hackerrank.datastructures;

import java.util.*;

public class BalancedParentheses {


    private static Map<Character, Character> parentheses = Map.of(
            '}', '{',
            ')', '(',
            ']', '[');


    public static void main(String[] args) {
        boolean balanced = isBalanced("{()[{({})[]()}]}([])");
//        boolean balanced = isBalanced("{()}");
        System.out.println(balanced);
    }

    private static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {

            if (parentheses.containsKey(c)) {
                if (stack.empty() || stack.pop() != parentheses.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
