public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring tester = new LongestPalindromeSubstring();
        String pal = tester.longestPalindrome("cbbd");
        System.out.print(pal);
    }

    public String longestPalindrome(String s) {
        String res = "";
        int SIZE = s.length();
        int[][] dp = new int[SIZE+1][SIZE+1];
        for (int i=1; i<SIZE+1; i++) {
            dp[i][i] = 1;
        }
        for (int i=2; i<SIZE+1; i++) {
            dp[i-1][i] = s.charAt(i-2) == s.charAt(i-1) ? 1:0;
        }
        for (int i=1; i<SIZE-1; i++) {
            for (int j=i+2; j<SIZE+1; j++) {
                dp[i][j] = s.charAt(i-1) == s.charAt(j-1) && dp[i+1][j-1] == 1 ? 1 : 0;
                if (dp[i][j] == 1 && (j-i) > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }
        for (int i=1; i<SIZE+1; i++) {
            for (int j=1; j<SIZE+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        
        return res;
    }
}
