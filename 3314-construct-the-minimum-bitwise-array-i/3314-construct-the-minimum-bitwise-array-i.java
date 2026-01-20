class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        
        //Collections.sort(nums);
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i<n;i++){
            for(int j=1;j<nums.get(i);j++){
                if((j|(j+1)) == nums.get(i)){
                    ans[i]=j;
                    break;
                } 
                else {
                    ans[i]=-1;
                
                }
            }
        }
        return ans;
    }
}