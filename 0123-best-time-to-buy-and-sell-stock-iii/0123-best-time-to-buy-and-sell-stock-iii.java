class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][][]=new Integer[prices.length][2][3];        
        return max(prices,0,0,0,dp);
    }
    private int max(int[]prices,int index,int canbuy,int count,Integer dp[][][]){
        if(count==2||index==prices.length){
            return 0;
        }
        if(dp[index][canbuy][count]!=null)return dp[index][canbuy][count];

        if(canbuy==0){
            return dp[index][canbuy][count] =Math.max(-prices[index]+max(prices,index+1,1,count,dp),max(prices,index+1,canbuy,count,dp));
        }
        else{
            return dp[index][canbuy][count]=Math.max(+prices[index]+max(prices,index+1,0,count+1,dp),max(prices,index+1,canbuy,count,dp));
        }
    }
}