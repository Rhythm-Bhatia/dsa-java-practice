class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //find number of subarrays with sum less than or equal to k
        //and number of subarray with sum less than equal to k-1
        int result=countSubArray(nums,k)-countSubArray(nums,k-1);
        return result;
    }
    private int countSubArray(int []nums,int k){
        int r=0,l=0,count=0,ans=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]%2!=0){
                count++;
            }
            while(count>k){
                if(nums[l]%2==0){
                    l++;
                }
                else{
                    count--;
                    l++;
                }
            }
            ans=ans+(r-l+1);
            r++;
        }
        return ans;
    }
}