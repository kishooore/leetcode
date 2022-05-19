public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare tester = new MaximalSquare();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int max = tester.maximalSquare(matrix);
        System.out.print(max);
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i=0; i<n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1:0;
            if (matrix[0][i] == '1') max = 1;
        }
        for (int i=0; i<m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1:0;
            if (matrix[i][0] == '1') max = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i-1][j-1] > 0) {
                        if (dp[i-1][j] >= dp[i-1][j-1] && dp[i][j-1] >= dp[i-1][j-1]) {
                            dp[i][j] = dp[i-1][j-1] + 1;
                        } else {
                            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                        }
                    } else {
                        dp[i][j] = matrix[i][j] == '1' ? 1:0;
                    }
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? 1:0;
                }
            }
        }
        return max*max;
    }
}
