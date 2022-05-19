public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions tester = new SurroundedRegions();
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        tester.solve(board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int boarder = m * n;
        UF uf = new UF(boarder+1);

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') continue;
                int cur = i*n + j;
                
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    uf.union(boarder, cur);
                    continue;
                }
            }
        }
    }

}

class UF {

    private int[] parents;
    private int[] rank;

    UF (int N) {
        parents = new int[N];
        rank = new int[N];

        for (int i=0; i<N; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int first, int second) {
        if (find(first) != find(second)) {
            parents[second] = find(first);
            rank[find(second)] = rank[find(first)] + rank[find(second)];
        }
    }

    public int find(int node) {
        if (node == parents[node]) return node;
        return find(parents[node]);
    }
}
