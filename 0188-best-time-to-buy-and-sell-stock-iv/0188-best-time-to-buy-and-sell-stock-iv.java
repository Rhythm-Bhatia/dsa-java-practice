// class Solution {
//     public int maxProfit(int k, int[] prices) {
        
//     }
// }
class Solution {
    public int maxProfit(int k,int[] prices) {
        Integer dp[][][]=new Integer[prices.length][2][k+1];        
        return max(prices,0,0,0,dp,k);
    }
    private int max(int[]prices,int index,int canbuy,int count,Integer dp[][][],int k){
        if(count==k||index==prices.length){
            return 0;
        }
        if(dp[index][canbuy][count]!=null)return dp[index][canbuy][count];

        if(canbuy==0){
            return dp[index][canbuy][count] =Math.max(-prices[index]+max(prices,index+1,1,count,dp,k),max(prices,index+1,canbuy,count,dp,k));
        }
        else{
            return dp[index][canbuy][count]=Math.max(+prices[index]+max(prices,index+1,0,count+1,dp,k),max(prices,index+1,canbuy,count,dp,k));
        }
    }
}