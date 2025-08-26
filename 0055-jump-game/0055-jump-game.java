class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        if(nums.length<=1)return true;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,i+nums[i]);
            if(max==i)return false;
            if(max==nums.length-1)break;
        }
        return true;
    }
}