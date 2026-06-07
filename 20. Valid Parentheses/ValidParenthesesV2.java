import java.util.Stack;
import java.util.Map;

public class ValidParenthesesV2 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character,Character> map = Map.of(')','(','}','{',']','[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            } else {
                // If the top of the stack does not match the expected opening bracket
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesesV2 solution = new ValidParenthesesV2();

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