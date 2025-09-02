class Solution {
    public int[] rearrangeArray(int[] nums) {
        int odd=1;
        int even=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                arr[odd]=nums[i];
                odd+=2;
            }
            else{
                arr[even]=nums[i];
                even+=2;
            }
        }
        return arr;
    }
}