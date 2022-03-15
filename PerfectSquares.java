public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares tester = new PerfectSquares();
        System.out.print(tester.numSquares(52));
    }

    public int numSquares(int n) {
        helper(n);
        return 0;
    }

    private boolean helper(int n) {
        if (n == 0) return true;
        if (n == 1) return true;
        if (n == 2) return false;
        if (n == 3) return false;
        int m = (int) Math.sqrt(n);
        while (m > 0) {
            if(helper(n - m*m)) {
                return true;
            } else {
                m--;
            }
        }
        return true;
    }
}
