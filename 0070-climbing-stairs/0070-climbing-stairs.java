class Solution {
    
    public int climbStairs(int n) {
        
        int dp[]=new int[n+1];
        return climb(dp,n);
        

    }
    public int climb(int[]dp,int n){
        if(n==1)return 1;
        if(n==2)return 2;
        if(dp[n]!=0)return dp[n];
        dp[n]=climb(dp,n-1)+climb(dp,n-2);
        return dp[n];

    }
}