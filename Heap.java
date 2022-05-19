import java.util.ArrayDeque;
import java.util.Queue;

public class Heap {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            // process adjacent cells
            for (int[] dir:dirs) {
                int nr = dir[0] + cell[0];
                int nc = dir[1] + cell[1];
                // skip if crossed boundary
                if (nr < 0 || nr > m-1) {
                    continue;
                }
                if (nc < 0 || nc > n-1) {
                    continue;
                }
                // skip if already processed
                if (mat[nr][nc] != -1) {
                    continue;
                }
                mat[nr][nc] = mat[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{nr,nc});
            }
        }

        return mat;
    }
}
