class Solution {

    public int change(int amount, int[] coins) {
        Integer dp[][]=new Integer[coins.length][amount+1];
        return solve(0, amount, coins,dp);
    }

    public int solve(int index, int amount, int[] coins,Integer[][]dp){

        if(amount == 0) return 1;

        if(amount < 0) return 0;

        if(index == coins.length) return 0;
        if(dp[index][amount]!=null){
            return dp[index][amount];
        }

        int take = solve(index, amount - coins[index], coins,dp);
        int skip = solve(index + 1, amount, coins,dp);

        return dp[index][amount]=take + skip;
    }
}