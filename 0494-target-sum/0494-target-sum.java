class Solution {
    int sum=0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        Integer dp[][]=new Integer[nums.length][2*sum+1];
        return target(0,nums,target,dp,0);

    }
    public int target(int index,int[] nums,int target,Integer dp[][],int currentSum){
        // if(Math.abs(target) > sum) return 0; 
        if(index==nums.length){
            if(currentSum==target){
                return 1;
            }
            else return 0;
        }
        if(dp[index][sum+currentSum]!=null){
            return dp[index][sum+currentSum];
        }
        int left=target(index+1,nums,target,dp,currentSum-nums[index]);
        int right=target(index+1,nums,target,dp,currentSum+nums[index]);
        return dp[index][sum+currentSum]=left+right;

    }
}