// class Solution {
//     public int rob(int[] nums) {
//         if(nums.length==0)return 0;
//         int dp[]=new int[nums.length+1];
//         Arrays.fill(dp,-1);
//         return robb(nums,0,dp);
//     }
//     public int robb(int[]nums,int index,int dp[]){
//         if(index>=nums.length)return 0;
//         if(dp[index]!=-1)return dp[index];
//         int rob=nums[index]+robb(nums,index+2,dp);
//         int skip=robb(nums,index+1,dp);
//         dp[index]=Math.max(rob,skip);
//         return dp[index];
//     }
// }
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];
        
        int dp[]=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}