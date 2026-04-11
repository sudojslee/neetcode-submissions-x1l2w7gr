class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i ++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        for (int j = 0; j < col; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        // 3 x 3
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                Set<Character> set = new HashSet<>();
                for (int i = a*3; i < (a+1)*3; i++) {
                    for (int j = b*3; j < (b+1)*3; j++) {
                        char c = board[i][j];
                        if (c != '.') {
                            if (set.contains(c)) {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }
}
