class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int heightOfTriangle = triangle.size();
        int[][] dp = new int[heightOfTriangle][heightOfTriangle];

        // Initialize last row with actual values
        for (int i = 0; i < heightOfTriangle; i++) {
            dp[heightOfTriangle - 1][i] = triangle.getLast().get(i);
        }

        // Work backwards from second-last row to top
        for (int i = heightOfTriangle - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = triangle.get(i).get(j) + 
                          Math.min(dp[i + 1][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }
}