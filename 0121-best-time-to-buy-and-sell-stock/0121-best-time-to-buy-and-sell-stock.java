class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int max=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            int ans=prices[i]-min;
            max=Math.max(max,ans);

        }
        return max;
    }
}