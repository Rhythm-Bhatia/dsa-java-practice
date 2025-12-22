class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum=0;
        int max=-1;
        int min=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            max=Math.max(sum,max);
            if(sum<0){
                min=Math.max(min,sum);
                sum=0;
            }
        }
        if(max<0)return min;

        return max;
    }
}