class Solution {
    
    public int climbStairs(int n) {
        if(n<=2)return n;
        int dp[]=new int[n+1];
        return climb(dp);
        

    }
    public int climb(int[]dp){
        dp[1]=1;
        dp[2]=2;
        
        
        for(int i=3;i<=dp.length-1;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[dp.length-1];
    }
}