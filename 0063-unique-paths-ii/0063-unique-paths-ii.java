class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return paths(obstacleGrid,0,0,dp);
    }
    public int paths(int[][]obstacleGrid,int i,int j,int[][]dp){
        if(i>=obstacleGrid.length||j>=obstacleGrid[0].length||obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1){
            return 1;
        }
        int right=paths(obstacleGrid,i,j+1,dp);
        int down=paths(obstacleGrid,i+1,j,dp);
        return dp[i][j]=right+down;

    }
}