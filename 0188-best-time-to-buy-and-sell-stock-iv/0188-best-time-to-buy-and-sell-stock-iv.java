
class Solution {
    int dp[][][];
    public int maxProfit(int k,int[] prices) {
        dp=new int[prices.length][2][k];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<k;l++){
                    dp[i][j][l]=-1;
                   

                }
                
            }
        }
        return profit(prices,0,0,0,k);
        
    }
    private int profit(int prices[],int index,int buyed,int transactions,int k){
        if(transactions==k||index==prices.length)return 0;
        if(dp[index][buyed][transactions]!=-1){
            return dp[index][buyed][transactions];
        }

        if(buyed==0){
            return dp[index][buyed][transactions]= Math.max(profit(prices,index+1,1,transactions,k)-prices[index],profit(prices,index+1,0,transactions,k));
        }
        else{
            return dp[index][buyed][transactions]=Math.max(profit(prices,index+1,0,transactions+1,k)+prices[index],profit(prices,index+1,1,transactions,k));
        }
    }
}