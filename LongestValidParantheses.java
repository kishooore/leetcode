public class LongestValidParantheses {
    public static void main(String[] args) {
        LongestValidParantheses tester = new LongestValidParantheses();
        String s = "((())(()";
//        String s = ")()())";
//        String s = ")()(())(";
        System.out.print(tester.longest(s));
    }

    private int longest(String s) {
        int n = s.length();
        int[][] dp = new int[s.length()][s.length()];
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                // odd window
                if ((j-i+1) % 2 == 1) dp[i][j] = i==j ? 0 : Math.max(dp[i+1][j], dp[i][j-1]);
                // open bracket
                else if (s.charAt(j) == '(') dp[i][j] = j-i == 1 ? 0 : dp[i][j-1];
                // close bracket
                else {
                    if (s.charAt(i) == '(' && j-i == 1) {
                        dp[i][j] = 2;
                    } else if (s.charAt(i) == '(' && j-i > 1 && dp[i+1][j-1] != 0) {
                        dp[i][j] = dp[i+1][j] + dp[i][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
