class Solution {
    public int minRemovals(int[] nums, int target) {
        Map<String,Integer>dp=new HashMap<>();
        
        int ans= min(0,nums,0,target,dp);
        if(ans==Integer.MAX_VALUE)return -1;
        else return ans;
    
        
    }
    private int min(int index,int nums[],int xoroutput,int target,Map<String,Integer>dp){
        if(index==nums.length){
            if(xoroutput==target){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        String key=index+","+xoroutput;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        //take
        int take=min(index+1,nums,xoroutput^nums[index],target,dp);
        //leave
        int leavee=min(index+1,nums,xoroutput,target,dp);
        if(leavee!=Integer.MAX_VALUE){
            leavee=leavee+1;
        }
        int res=Math.min(take,leavee);
        dp.put(key,res);
        return res;
    }
}