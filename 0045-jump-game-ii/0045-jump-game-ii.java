class Solution {
    public int jump(int[] nums) {
        int i=0;
        int max=0;
        int jump=0;
        int j=0;
        int count=0;
        if(nums.length<=1){
            return jump;
        }
        while(i<=nums.length-1){
            jump=nums[i]+i;
            j=i+1;
            if(jump>=nums.length-1){
                return count+1;
            }
            while(j<=jump){
                if(nums[j]+j>max){
                    max=nums[j]+j;
                    i=j;
                    
                }
                j++;
            }
            count++;
        }
        return count;
    }
}