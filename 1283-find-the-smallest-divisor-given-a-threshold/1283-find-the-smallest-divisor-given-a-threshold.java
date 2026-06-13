class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            high=Math.max(high,nums[i]);

        }
        while(low<=high){
            int mid=(low+high)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if((nums[i]%mid)==0){
                    sum=sum+(nums[i]/mid);
                }
                else{
                    sum=sum+(nums[i]/mid)+1;
                }
            }
            if(sum<=threshold){
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}