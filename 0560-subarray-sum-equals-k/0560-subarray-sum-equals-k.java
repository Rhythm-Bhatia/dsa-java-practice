// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         // int sum=0;
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum=sum+nums[j];
//                 if(sum==k){
//                     count++;
//                 }
//             }
//         }
//         return count;

//     }

// }
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int left = 0, sum = 0, count = 0;

//         for (int right = 0; right < nums.length; right++) {
//             sum += nums[right];

//             // Shrink from left if sum too big
//             while (sum > k && left <= right) {
//                 sum -= nums[left];
//                 left++;
//             }

//             // Check if sum == k
//             if (sum == k) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }
class Solution{
    public int subarraySum(int[]nums,int k){
        int prefixSum=0;
        int count=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        
        for(int i=0;i<nums.length;i++){

            prefixSum=nums[i]+prefixSum;
            

            if(map.containsKey(prefixSum-k)){
                count=count+map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);


        }
        return count;
    }
}
