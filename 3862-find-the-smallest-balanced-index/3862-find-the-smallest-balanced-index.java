class Solution {
    public int smallestBalancedIndex(int[] nums) {
        if(nums.length==1)return -1;
        int ans=-1;
        int n=nums.length;
        long LIMIT = 100000L * 1000000000L;
        
        long prefix[]=new long[n];
        long suffix[]=new long[n];
        prefix[0]=0;
        suffix[n-1]=1;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
            if(prefix[i]>=LIMIT){
                // suffix[i]=Integer.MAX_VALUE;
                prefix[i]=LIMIT+1;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            
            if(suffix[i+1] > LIMIT / nums[i+1]){
                suffix[i] = LIMIT + 1;
            }
            else{
                suffix[i] = suffix[i+1] * nums[i+1];
            }
        } 
        for(int i = 0; i < n; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        return -1;
    }
}