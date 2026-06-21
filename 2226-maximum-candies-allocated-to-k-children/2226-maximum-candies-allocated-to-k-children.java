
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        int ans=0;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            high=Math.max(high,candies[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            long temp=k;
            
            for(int i=0;i<candies.length;i++){
                int divide=candies[i]/mid;
                temp=temp-divide;
            }
            if(temp<=0){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}