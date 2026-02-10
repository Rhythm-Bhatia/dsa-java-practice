// class Solution {
//     public int longestBalanced(int[] nums) {
//         Map<Integer,Integer>map=new HashMap<>();
//         Set<Integer>set=new HashSet();
//         int odd=0;
//         int even=0;
//         for(int i=0;i<nums.length;i++){
//             if((nums[i]&1)!=0&&!set.contains(nums[i])){
//                 odd++;
//                 set.add(nums[i]);
//             }
//             else if((nums[i]&1)==0&&!set.contains(nums[i])){
//                 even++;
//                 set.add(nums[i]);
//             }
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         int evenn=0;
//         int oddd=0;
//         if(even==odd)return nums.length;
//         if(even>odd){
//             evenn=even-odd;
//         }
//         else oddd=odd-even;
//         int ans=nums.length;
        
        

//         while(oddd!=0){
//             int min=Integer.MAX_VALUE;
//             int key=0;
//             for(Map.Entry<Integer,Integer>entry:map.entrySet()){
//                 if(entry.getKey()%2!=0&&entry.getValue()<min){
//                     min=entry.getValue();
//                     key=entry.getKey();
//                 }
//             }
//             ans=ans-min;
//             map.remove(key);
//             odd--;
//         }
//         while(evenn!=0){
//             int min=0;
//             int key=0;
//             for(Map.Entry<Integer,Integer>entry:map.entrySet()){
//                 if(entry.getKey()%2==0&&entry.getValue()<min){
//                     min=entry.getValue();
//                     key=entry.getKey();
//                 }
//             }
//             ans=ans-min;
//             map.remove(key);
//         }
//         return ans;
//     }
// }
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 0) even.add(nums[j]);
                else odd.add(nums[j]);

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
