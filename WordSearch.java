public class WordSearch {
    public static void main(String[] args) {
        WordSearch tester = new WordSearch();
        char[][] board = {{'A'}};
        String word = "A";
        boolean found = tester.wordSearch(board, word);
        System.out.println(found);
    }

    private boolean wordSearch(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean matched = exploreCell(board, visited, word, i, j);
                    if (matched) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exploreCell(char[][] board, int[][] visited, String word, int i, int j) {
        if (!(i >= 0 && i <= board.length - 1) || !(j >= 0 && j <= board[0].length - 1)) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        if (board[i][j] != word.charAt(0)) {
            return false;
        }
        visited[i][j] = 1;
        //System.out.println(i + ", " + j);
        if (word.length()-1 != 0) {
            boolean found = exploreCell(board, visited, word.substring(1), i + 1, j) ||
                exploreCell(board, visited, word.substring(1), i - 1, j) ||
                exploreCell(board, visited, word.substring(1), i, j + 1) ||
                exploreCell(board, visited, word.substring(1), i, j - 1);
            if (found) return true;
            visited[i][j] = 0;
            return false;
        } else {
            return true;
        }
    }
}
