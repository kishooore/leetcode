import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> possibilities = nQueens.solveNQueens(4);
        for (List<String> possibility:possibilities) {
            for (String row:possibility) {
                System.out.println(row);
            }
            System.out.println("");
        }
    }

    List<List<String>> solveNQueens(int N) {
        char[][] board = new char[N][N];
        for (char[] row:board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> possibilities = new ArrayList<>();
        backtrack(board, 0, possibilities);
        return possibilities;
    }

    void backtrack(char[][] board, int col, List<List<String>> possibilities) {
        if (col == board.length) {
            List<String> possibility = new ArrayList<>();
            for (char[] row:board) {
                possibility.add(new String(row));
            }
            possibilities.add(possibility);
            return;
        }

        for (int i=0; i<board.length; i++) {
            if (board[i][col] == '.' && isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, possibilities);
                board[i][col] = '.';
            }
        }
    }

    boolean isValid(char[][] board, int x, int y) {
        int N = board.length;
        for (int i=0; i<N; i++) {
            if (board[i][y] == 'Q') return false;
        }
        for (int j=0; j<N; j++) {
            if (board[x][j] == 'Q') return false;
        }
        int i = x;
        int j = y;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = x;
        j = y;
        while (i < N && j < N) {
            if (board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        i = x;
        j = y;
        while (i >= 0 && j < N) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = x;
        j = y;
        while (j >= 0 && i < N) {
            if (board[i][j] == 'Q') return false;
            j--;
            i++;
        }
        return true;
    }
}
