class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=2;
        while(j<nums.length-1){
            if(nums[i]!=nums[j])return nums[i];
            i=j+1;
            j=j+3;
        }
        return nums[nums.length-1];
    }
}