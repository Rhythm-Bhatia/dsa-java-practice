class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int sum=0;
        int max=0;
        while(i<j){
            sum=nums[i]+nums[j];
            max=Math.max(sum,max);
            i++;
            j--;
        }
        return max;
    }
}