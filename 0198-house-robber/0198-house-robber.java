class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robb(nums,0,dp);
    }
    public int robb(int[]nums,int index,int dp[]){
        if(index>=nums.length)return 0;
        if(dp[index]!=-1)return dp[index];
        int rob=nums[index]+robb(nums,index+2,dp);
        int skip=robb(nums,index+1,dp);
        dp[index]=Math.max(rob,skip);
        return dp[index];
    }
}