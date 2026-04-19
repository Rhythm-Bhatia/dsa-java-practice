

class Solution {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        // top row
        for (int j = 0; j < m; j++) {
            if (!visited[0][j] && grid[0][j] == 1) {
                dfs(grid, 0, j, visited);
            }
        }

        // right column
        for (int i = 0; i < n; i++) {
            if (!visited[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, visited);
            }
        }

        // bottom row
        for (int j = m - 1; j >= 0; j--) {
            if (!visited[n - 1][j] && grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, visited);
            }
        }

        // left column
        for (int i = n - 1; i >= 0; i--) {
            if (!visited[i][0] && grid[i][0] == 1) {
                dfs(grid, i, 0, visited);
            }
        }

        // count remaining land (not visited)
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, i, j + 1, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i - 1, j, visited);
    }
}