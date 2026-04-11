import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int count = 0;

       
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                    flag = true;
                }

               
                if (x + 1 < n && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                    flag = true;
                }

              
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                    flag = true;
                }

                
                if (y + 1 < m && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                    flag = true;
                }
            }

            if (flag) count++;
        }

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return count;
    }
}