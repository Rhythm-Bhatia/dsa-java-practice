class Solution {
    public int maxProfit(int[] prices) {
        int sell=prices[prices.length-1];
        int max=0;
        int profit=0;
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>sell){
                sell=prices[i];
            }
            else if(prices[i]<sell){
                profit=sell-prices[i];
                max=Math.max(profit,max);
            }

            
        }
        return max;
    }
}