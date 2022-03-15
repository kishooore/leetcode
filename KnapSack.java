public class KnapSack {
    public static void main(String[] args) {
        KnapSack tester = new KnapSack();
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int maxProfit = tester.knapsack(weights, values, capacity, weights.length);
        System.out.print(maxProfit);
    }

    public int knapsack(int[] w, int[] v, int W, int n) {
        int[][] memory = new int[W+1][n+1];
        for (int i=0; i<memory.length; i++) {
            for (int j=0; j<memory[i].length; j++) {
                memory[i][j] = -1;
            }
        }
        if (W == 0 || n == 0) {
            return 0;
        }
        if (memory[W][n] != -1) {
            return memory[W][n];
        }
        if (w[n-1] <= W) {
            int result = Math.max(v[n-1] + knapsack(w, v, W-w[n-1], n-1), knapsack(w, v, W, n-1));
            memory[W][n] = result;
            return result;
        }
        int result = knapsack(w, v, W, n-1);
        memory[W][n] = result;
        return result;
    }
}

// Steps to solve recursion problem
// 1. identity the repeated pattern
// 2. identity the inputs of the function
// 3. base condition: think of smallest possible valid input space
// 4. implment the function
//      - choice diagram
