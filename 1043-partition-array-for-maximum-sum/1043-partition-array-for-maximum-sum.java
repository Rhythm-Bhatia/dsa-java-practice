class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp=new Integer[arr.length];
        return solve(arr,k,0,dp);
    }
    private int solve(int []arr,int k,int i,Integer[]dp){
        if(i>=arr.length)return 0;
        if(dp[i]!=null)return dp[i];

        int max=-1;
        int maxx=Integer.MIN_VALUE;
        for(int j=i;j<i+k&&j<arr.length;j++){
            max=Math.max(arr[j],max);
            int temp=max*(j-i+1)+solve(arr,k,j+1,dp);
            maxx=Math.max(maxx,temp);
        }
        return dp[i]=maxx;
    }
}