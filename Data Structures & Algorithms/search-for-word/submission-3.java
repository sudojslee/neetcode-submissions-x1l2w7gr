class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean exists = startSearch(board, i, j, 0, word);
                    if (exists) {
                        return true;
                    }
                }
            }
        }    

        return false;    
    }

    private boolean startSearch(char[][] board, int i, int j, int index, String word) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        

        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (board[i][j] == '.') {
            return false;
        }

        char temp = board[i][j];
        // mark as visited
        board[i][j] = '.';

        boolean result = startSearch(board, i+1, j, index + 1, word) ||
            startSearch(board, i-1, j, index + 1, word) ||
            startSearch(board, i, j-1, index + 1, word) ||
            startSearch(board, i, j+1, index + 1, word);

        board[i][j] = temp;
        return result;
    }
}
