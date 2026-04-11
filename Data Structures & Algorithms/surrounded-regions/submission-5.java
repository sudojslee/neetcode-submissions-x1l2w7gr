class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // dfs for edges with 'O'
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[row - 1][j] == 'O') {
                dfs(board, row - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }   
            }
        }
    }


    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length) {
            return;
        }
        if (j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'V';

        dfs(board, i -1 , j);
        dfs(board, i +1 , j);
        dfs(board, i , j - 1);
        dfs(board, i , j + 1);
    }
}
