class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int ans=subArr(nums,goal)-subArr(nums,goal-1);
        return ans;
    }
    private int subArr(int[] nums,int goal){  
        if(goal<0)return 0;
        int l=0;
        int r=0;
        int sum=0;
        int count=0;
        int n=nums.length;
        while(r<n){
            sum=sum+nums[r];
            
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            count=count+(r-l+1);
            r++;

        }
        return count;
        
    }

}