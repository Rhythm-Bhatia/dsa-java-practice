class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {

       
        if (i == 9) return true;

        
        if (j == 9) return solve(board, i + 1, 0);

        
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }

        
        for (char k = '1'; k <= '9'; k++) {

            if (isValid(board, i, j, k)) {

                board[i][j] = k;

                if (solve(board, i, j + 1)) {
                    return true;
                }

                // backtrack
                board[i][j] = '.';
            }
        }

        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char k) {

     
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == k) return false;
        }

        for (int row = 0; row < 9; row++) {
            if (board[row][j] == k) return false;
        }

        
        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;

        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == k) return false;
            }
        }

        return true;
    }
}