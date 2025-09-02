class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int current=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            current=nums[i];
            sum=sum+current;
            sum=Math.max(sum,current);
            max=Math.max(sum,max);

        }
        return max;
    }
}