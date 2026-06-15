class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            high=high+nums[i];
            low=Math.max(low,nums[i]);
        }
        while(low<=high){
            int mid=(low+high)/2;
            int tempk=0;
            int tempmid=mid;
            
            for(int i=0;i<nums.length;i++){
                
                if(nums[i]>tempmid){
                    tempk++;
                    tempmid=mid;
                }
                tempmid=tempmid-nums[i];
            }
            if(tempk<=k-1){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
}