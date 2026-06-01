class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int reference=-1;
        while(high>=low){
            int mid=(high+low)/2;
            if(nums[mid]==target){
                reference=mid;
                break;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(reference==-1){
            return new int[]{-1,-1};
        }
        int start=reference;
        int end=reference;
        while(start>=0){
            if(nums[start]==nums[reference]){

                start--;
            }
            else{
                break;
            }
        }
        while(end<nums.length){
            if(nums[end]==nums[reference]){
                end++;
            }
            else{
                break;
            }
        }
        return new int[]{start+1,end-1};
    }
}