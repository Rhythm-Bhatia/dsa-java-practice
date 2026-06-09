class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(low==high)return 0;
        if(high==low+1){
            if(nums[high]>nums[low])return high;
            else return low;
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1])return mid;
                // else return -1;
            }
            else if(mid==0){
                if(nums[mid]>nums[mid+1])return 0;
                // else return -1;
            }
            int m=nums[mid];
            int mprev=0;
            int mnext=Integer.MIN_VALUE;
            int mprevv=Integer.MIN_VALUE;
            if(mid!=0){
                mprevv=nums[mid-1];
            }
            
            if(mid!=nums.length-1){
                mnext=nums[mid+1];
            }
            
            
            
            if(m>mnext&&m>mprevv){
                return mid;
            }
            else if(mnext>mprevv){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}