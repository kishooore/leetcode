public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {{5,3,0,0,7,0,0,0,0},
                         {6,0,0,1,9,5,0,0,0},
                         {0,9,8,0,0,0,0,6,0},
                         {8,0,0,0,6,0,0,0,3},
                         {4,0,0,8,0,3,0,0,1},
                         {7,0,0,0,2,0,0,0,6},
                         {0,6,0,0,0,0,2,8,0},
                         {0,0,0,4,1,9,0,0,5},
                         {0,0,0,0,8,0,0,7,9}};
        Sudoku sudoku = new Sudoku();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        sudoku.solve(board);
        System.out.println("-------------------");
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean solve(int[][] board) {
        for (int i=0; i<board[0].length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 0) {
                    for (int k=1; k<=9; k++) {
                        if (isValid(board, k, i, j)) {
                            board[i][j] = k;
                            if(solve(board)) {
                                return false;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int num, int row, int col) {
        if (checkRow(board, num, row)) {
            return false;
        }
        if (checkCol(board, num, col)) {
            return false;
        }
        if (checkGrid(board, num, row, col)) {
            return false;
        }
        return true;
    }

    private boolean checkRow(int[][] board, int num, int row) {
        for (int j=0; j<board[row].length; j++) {
            if (board[row][j] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int[][] board, int num, int col) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean checkGrid(int[][] board, int num, int row, int col) {
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for (int i=startRow; i<3; i++) {
            for (int j=startCol; j<3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
