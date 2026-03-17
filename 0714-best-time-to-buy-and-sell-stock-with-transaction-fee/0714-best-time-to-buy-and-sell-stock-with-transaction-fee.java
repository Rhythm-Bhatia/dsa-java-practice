// class Solution {
//     public int maxProfit(int[] prices, int fee) {
        
//     }
// }
class Solution {
    public int maxProfit(int[] prices,int fee) {
        Integer dp[][]=new Integer[prices.length][2];        
        return max(prices,0,0,dp,fee);
    }
    private int max(int[]prices,int index,int canbuy,Integer dp[][],int fee){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][canbuy]!=null)return dp[index][canbuy];

        if(canbuy==0){
            return dp[index][canbuy] =Math.max(-prices[index]+max(prices,index+1,1,dp,fee),max(prices,index+1,canbuy,dp,fee));
        }
        else{
            return dp[index][canbuy]=Math.max(-fee+prices[index]+max(prices,index+1,0,dp,fee),max(prices,index+1,canbuy,dp,fee));
        }
    }
}