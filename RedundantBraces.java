import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        RedundantBraces rb = new RedundantBraces();
        System.out.print(rb.braces("((a+b)+a)"));
    }

    public int braces(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                boolean didPopSymbol = false;
                while(stack.peek() != '(') {
                    didPopSymbol = true;
                    stack.pop();
                }
                if (!didPopSymbol) return 1;
                stack.pop();
            }
            i++;
        }
        return 0;
    }
}
