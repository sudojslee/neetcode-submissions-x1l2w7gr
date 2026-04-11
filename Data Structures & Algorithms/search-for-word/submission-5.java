class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // visited
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (index > word.length()) {
            return false;
        }
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '.';
        boolean result = false;
        index++;
        result = result || dfs(board, i + 1, j, index, word);
        result = result || dfs(board, i - 1, j, index, word);
        result = result || dfs(board, i, j - 1, index, word);
        result = result || dfs(board, i, j + 1, index, word);

        board[i][j] = temp;

        return result;
    }
}
