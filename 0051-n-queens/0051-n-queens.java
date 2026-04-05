import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, 0, 0, n, board, result);

        return result;
    }

    private void solve(int i, int j, int queens, int n, char[][] board, List<List<String>> result) {

        // base cases
        if (queens == n) {
            List<String> temp = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                temp.add(new String(board[r]));
            }
            result.add(temp);
            return;
        }

        if (i == n) return;

        // OPTION 1: place queen
        if (isValid(board, i, j, n)) {
            board[i][j] = 'Q';

            if (j + 1 == n) {
                solve(i + 1, 0, queens + 1, n, board, result);
            } else {
                solve(i, j + 1, queens + 1, n, board, result);
            }

            // backtrack
            board[i][j] = '.';
        }

        // OPTION 2: skip this cell
        if (j + 1 == n) {
            solve(i + 1, 0, queens, n, board, result);
        } else {
            solve(i, j + 1, queens, n, board, result);
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {

        // column check
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // row check
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // diagonals
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}