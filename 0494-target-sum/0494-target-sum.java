class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // int dp[][]=new int[nums.length][]
        return target(0,nums,target);

    }
    public int target(int index,int[] nums,int target){
        if(index==nums.length){
            if(target==0){
                return 1;
            }
            else return 0;
        }
        int left=target(index+1,nums,target-nums[index]);
        int right=target(index+1,nums,target+nums[index]);
        return left+right;
    }
}