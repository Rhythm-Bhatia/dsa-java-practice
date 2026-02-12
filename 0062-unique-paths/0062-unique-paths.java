class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return paths(m,n,0,0,dp);
    }
    private int paths(int m,int n,int i,int j,int[][]dp){
        if(i==m-1&&j==n-1){
            return 1;

        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(i>=m||j>=n)return 0;
        int right=paths(m,n,i,j+1,dp);
        int down=paths(m,n,i+1,j,dp);
        return dp[i][j]=right+down;
    }
}