import java.util.*;

class Solution {

    class Pair {

        int value;
        int row;
        int col;

        Pair(int value,
             int row,
             int col) {

            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[] row =
            {-1, 0, 1, 0};

        int[] col =
            {0, 1, 0, -1};

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a, b) ->
                    a.value - b.value
            );

        boolean[][] vis =
            new boolean[n][n];

        pq.add(
            new Pair(
                grid[0][0],
                0,
                0
            )
        );

        vis[0][0] = true;

        int max = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int val = curr.value;
            int r = curr.row;
            int c = curr.col;

            max = Math.max(max, val);

            if (r == n - 1 &&
                c == n - 1) {

                return max;
            }

       
            for (int i = 0;
                     i < 4;
                     i++) {

                int nr =
                    r + row[i];

                int nc =
                    c + col[i];

                if (nr >= 0 &&
                    nr < n &&
                    nc >= 0 &&
                    nc < n) {

                    if (!vis[nr][nc]) {

                        pq.add(
                            new Pair(
                                grid[nr][nc],
                                nr,
                                nc
                            )
                        );

                        vis[nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }
}