class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][]=new double[query_row+1][query_glass+1];
        for(int i=0;i<query_row+1;i++){
            for(int j=0;j<query_glass+1;j++){
                dp[i][j]=-1;
            }
        }
        return Math.min(1.0,tower(poured,query_row,query_glass,dp));

        
    }
    public double tower(int poured,int i,int j,double[][]dp){
        if(i<0||j<0||i<j)return 0.0;
        if(i==0&&j==0)return poured;
        if(dp[i][j]!=-1)return dp[i][j];

        double left_up=(tower(poured,i-1,j-1,dp)-1)/2.0;
        double right_up=(tower(poured,i-1,j,dp)-1)/2.0;

        if(left_up <0.0){
            left_up=0.0;
        }
        if(right_up<0.0){
            right_up=0.0;
        }
        return dp[i][j]=left_up + right_up;

        

    }
}