import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath tester = new SimplifyPath();
        System.out.print(tester.simplifyPath("/a/./b/../../c/"));
    }

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir:dirs) {
            if ("..".equals(dir)) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else if (!"".equals(dir)){
                if (!".".equals(dir)) {
                    stack.push(dir);
                }
            }
        }
        String canonical = "";
        while(!stack.isEmpty()) {
            canonical = "/" + stack.pop() + canonical;
        }
        return "".equals(canonical) ? "/": canonical;
    }
}
