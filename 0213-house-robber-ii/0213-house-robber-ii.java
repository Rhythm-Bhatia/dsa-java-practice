class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int dp1[]=new int[nums.length];
        int dp2[]=new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int one=memo(nums,dp1,0,nums.length-2);
        int two=memo(nums,dp2,1,nums.length-1);
        return Math.max(one,two);


    }
    public int memo(int []nums,int dp[],int start,int end){
        if(start>end)return 0;
        if(dp[start]!=-1)return dp[start];
        int take=nums[start]+memo(nums,dp,start+2,end);
        int skip=memo(nums,dp,start+1,end);
        return dp[start]=Math.max(take,skip);
    }
}