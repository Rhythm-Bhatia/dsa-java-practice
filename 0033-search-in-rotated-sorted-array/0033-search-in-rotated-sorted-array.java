class Solution {
    public int search(int[] nums, int target) {
        int arr[]=new int[nums.length*2];
        for(int i=0;i<nums.length*2;i++){
            arr[i]=nums[i%nums.length];
        }
        int high=arr.length-1;
        int low=nums.length;
        while(arr[low-1]<arr[low]){
            low=low-1;
        }
        high=low+nums.length-1;
        int remain=low;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                
                return mid%nums.length;
                
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return -1;
    }
}