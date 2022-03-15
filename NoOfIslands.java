public class NoOfIslands {
    public static void main(String[] args) {
        NoOfIslands tester = new NoOfIslands();
        char[][] grid = {
                  {'1','1','0','0','0'},
                  {'1','1','0','0','0'},
                  {'0','0','1','0','0'},
                  {'0','0','0','1','1'}
                };
        System.out.print(tester.count(grid));
    }

    public int count(char[][] grid) {
        int maxArea = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    int area = exploreLand(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int exploreLand(char[][] grid, int i, int j, int[][] visited) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return 0;
        if (grid[i][j] == '0' || visited[i][j] == 1 ) return 0;
        visited[i][j] = 1;
        int area = 1;
        area += exploreLand(grid, i-1, j, visited);
        area += exploreLand(grid, i+1, j, visited);
        area += exploreLand(grid, i, j-1, visited);
        area += exploreLand(grid, i, j+1, visited);
        return area;
    }
}
