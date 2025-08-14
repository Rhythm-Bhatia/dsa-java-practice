class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int maxCount=0;
        int count=0;
        int count2=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]==1){
                count++;
                maxCount=Math.max(maxCount,count);
            }
            else{
                if(count2>=k){
                    while(nums[l]!=0){
                        
                        count--;
                        l++;


                    }
                    count--;
                    l++;
                    count2--;

                }
                if(count2<k){
                    count++;
                    count2++;
                    maxCount=Math.max(maxCount,count);
                }
                
               
            }
            r++;
        }
        return maxCount;
    }
}