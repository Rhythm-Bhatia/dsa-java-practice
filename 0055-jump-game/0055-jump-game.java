class Solution {
    public boolean canJump(int[] nums) {
        boolean arr[]=new boolean[nums.length];
        arr[0]=true;
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            if(arr[i]==false)return false;
            for(int j=i+1;j<=nums[i]+i;j++){
                if(j==arr.length)return true;
                arr[j]=true;
                

            }

        }
        return true;
    }
}