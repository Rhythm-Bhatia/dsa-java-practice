class Solution {
    public int subarraySum(int[] nums, int k) {
        // int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;

    }

}
// class Solution{
//     public int subarraySum(int[]nums,int k){
//         int start=0;
//         int end=0;
//         int sum=0;
//         while(end<=nums.length && start<=end){
//             sum=sum+nums[end];

            
//             if(sum==k){
//                 count++;
                
//             }
//             while(sum>k){
//                 sum=sum-nums[start];
//                 start++;
//                 if(sum==k){
//                     count++;
//                 }
//             }
//             end++;
//         }
//         return count;
//     }
// }