public class UniquePaths2 {
    int[][] mem;
    public static void main(String[] args) {
        UniquePaths2 tester = new UniquePaths2();
        int[][] grid = {{0},{0}};
        System.out.print(tester.uniquePathsWithObstacles(grid));
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid[grid.length-1][grid[0].length-1] == 1) return 0;   
        mem = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                mem[i][j] = -1;
            }
        }
        return paths(grid, 0, 0);
    }
    
    private int paths(int[][] grid, int row, int col) {
        // end
        if (row == grid.length-1 && col == grid[0].length-1) {
            //mem[row][col] = 1;
            return 1;
        }

        // out of boudary
        if (row >= grid.length || col >= grid[0].length) {
            //mem[row][col] = 0;
            return 0;
        }
        
        // with in and obstractle
        if (row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            mem[row][col] = 0;
            return 0;
        }
        
        // previous visit
        if (mem[row][col] != -1) {
            return mem[row][col];
        }

        mem[row][col] = paths(grid, row+1, col) + paths(grid, row, col+1);
        return mem[row][col];
    }
}
