import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        ValidParanthesis tester = new ValidParanthesis();
        boolean valid = tester.isValid("{}[]()");
        System.out.print(valid);
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        for (Character c : str.toCharArray()) {
            if ('[' == c || '{' == c || '(' == c) {
                stack.push(c);
            } else {
                if (stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
