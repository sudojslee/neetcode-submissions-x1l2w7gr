class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. col
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0';
                if (set.contains(num)) {
                    System.out.println("col");
                    return false;
                }
                set.add(num);
            }
        }
        // 2. rows
        for (int j = 0; j < 9; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0';
                if (set.contains(num)) {
                    System.out.println("row");
                    return false;
                }
                set.add(num);
            }
        }
        
        // 3. diag
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            char c = board[i][i];
            if (c == '.') continue;
            int num = c - '0';
            if (set.contains(num)) {
                System.out.println("diag");
                return false;
            }
            set.add(num);

            Set<Integer> setB = new HashSet<>();
            int num2 = board[i][8-i];
            if (setB.contains(num2)) {
                return false;
            }
            setB.add(num2);
        }

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0 + a*3; i < 3*(a+1); i++) {
                    for (int j = 0 + b*3; j < 3*(b+1); j++) {
                        char c = board[i][j];
                        if (c == '.') continue;
                        int num = c - '0';
                        // System.out.println(i + "," + j + ":" + num);
                        if (set.contains(num)) {
                            return false;
                        }
                        set.add(num);
                    }
                }
            }
        }

        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         Set<Integer> set = new HashSet<>();
        //         char c = board[i][i];
        //         if (c == '.') continue;
        //         int num = c - '0';
        //         if (set.contains(num)) {
        //             return false;
        //         }
        //         set.add(num);
        //     }
        // }


        return true;
        // 4. each 3x3 square
    }
}
