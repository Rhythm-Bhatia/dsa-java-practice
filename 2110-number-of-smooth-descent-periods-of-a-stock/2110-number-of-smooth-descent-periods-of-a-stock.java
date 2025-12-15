class Solution {
    public long getDescentPeriods(int[] prices) {
        long count=0;
        int num=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]+1==prices[i-1]){
                count++;
                num++;
            }
            else{
                num=0;
            }
            if(num>1){
                count--;
                count=count+num;
            }
        }
        return count+(long)n;
    }
}