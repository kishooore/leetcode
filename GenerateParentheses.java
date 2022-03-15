import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses tester = new GenerateParentheses();
        tester.generateParenthesis(2);
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(int n, int open, int closed, String prefix, List<String> ans) {
        if (open == n && closed == n) {
            ans.add(new String(prefix));
            return;
        }
        if (open < n) {
            backtrack(n, open+1, closed, prefix + "(", ans);
        }
        if (closed < n && open > closed) {
            backtrack(n, open, closed+1, prefix + ")", ans);
        }
    }
}
