class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        for(int i=0;i<ans.length;i++){
            if(nums.get(i)%2==0){
                ans[i]=-1;
                continue;
            }
            for(int j=1;j<32;j++){
                if((nums.get(i) & (1<<j))!=0){
                    continue;
                }
                int prev=j-1;
                int x=(nums.get(i)^(1<<(j-1)));
                ans[i]=x;
                break;

            }

        }
        return ans;
    }
}