public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths tester = new UniquePaths();
        int res = tester.uniquePaths(23, 12);
        System.out.print(res);
    }
    
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m+1][n+1];
        return helper(m,n,mem);
    }
    
    public int helper(int m, int n, int[][] mem) {
        if (mem[m][n] != 0) return mem[m][n];
        if (m > 1 && n > 1) {
            int ans = uniquePaths(m, n-1) + uniquePaths(m-1, n);
            mem[m][n] = ans;
            return ans;
        }
        if (m == 1 && n == 1) return 1;
        if (m == 1 && n > 1) return 1;
        if (m > 1 && n == 1) return 1;
        return 0;
    }
}
