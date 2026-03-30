class Solution {
    public int countSquares(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==1){
                dp[i][0]=1;
                sum=sum+dp[i][0];
            }
            else dp[i][0]=0;
            

        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==1){
                dp[0][j]=1;
                sum+=dp[0][j];
            }
            else dp[0][j]=0;

        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    sum+=dp[i][j];
                }
                else dp[i][j]=0;
                
            }
        }
        return sum;
    }
}