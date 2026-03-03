class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        int ans=coin(0,coins,amount,dp);
        if(ans>=100000)return -1;
        else {
            return ans;
        }
        
    }
    public int coin(int index,int[]coins,int amount,int dp[][]){
        if(amount==0)return 0;
        if(index==coins.length){
            return 100000;
        }
        if(dp[index][amount]!=-1)return dp[index][amount];
        int pick=100000;
        if(amount>=coins[index]){
            pick = 1 + coin(index, coins, amount - coins[index],dp);
        }
        int not_pick=coin(index+1,coins,amount,dp);

        return dp[index][amount]=Math.min(pick,not_pick);
        
    }
}