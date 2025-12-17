class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
                dp[i][j][2]=-1;
            }
        }
        return profit(prices,0,0,0);
        
    }
    private int profit(int prices[],int index,int buyed,int transactions){
        if(transactions==2||index==prices.length)return 0;
        if(dp[index][buyed][transactions]!=-1){
            return dp[index][buyed][transactions];
        }

        if(buyed==0){
            return dp[index][buyed][transactions]= Math.max(profit(prices,index+1,1,transactions)-prices[index],profit(prices,index+1,0,transactions));
        }
        else{
            return dp[index][buyed][transactions]=Math.max(profit(prices,index+1,0,transactions+1)+prices[index],profit(prices,index+1,1,transactions));
        }
    }
}