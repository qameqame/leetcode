import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.get(stack.size() - 1) == '(') {
                stack.remove(stack.size() - 1);
            } else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.get(stack.size() - 1) == '{') {
                stack.remove(stack.size() - 1);
            } else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.get(stack.size() - 1) == '[') {
                stack.remove(stack.size() - 1);
            }
        }

        if (stack.size() > 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // テストケース
        String[] testCases = { "()", "()[]{}", "(]", "([)]", "{[]}", "", "(((" };
        boolean[] expected  = { true,  true,    false, false,  true,  true, false };

        for (int i = 0; i < testCases.length; i++) {
            boolean result = solution.isValid(testCases[i]);
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.printf("[%s] isValid(\"%s\") => %b (expected: %b)%n",
                    status, testCases[i], result, expected[i]);
        }
    }
}