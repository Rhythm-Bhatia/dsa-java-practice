class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans=Integer.MAX_VALUE;
        int low=1;
        int high=piles[0];
       
        for(int i=0;i<piles.length;i++){
            if(piles[i]>high){
                high=piles[i];
                
            }
            
        }
        // int ans=Integer.MAX_VALUE;
        while(high>=low){
            int mid=(high+low)/2;
            long sum=0;
            for(int element:piles){
                if(element%mid==0){
                    int div=element/mid;
                    sum=sum+div;
                }
                else{
                    int div=element/mid+1;
                    sum=sum+div;
                }
            }
            if(sum<=h){
                high=mid-1;
                ans=Math.min(mid,ans);
            }
            else{
                low=mid+1;
            }
            

        }
        return ans;
    }
}