class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int dp[]=new int[nums.length];
    Arrays.sort(nums);
    Arrays.fill(dp,1);
    int max=1;
    int store=0;
    int prev[]=new int[nums.length];
    Arrays.fill(prev,-1);
    for(int i=0;i<nums.length;i++){
        for(int j=i-1;j>=0;j--){
            if(nums[i]%nums[j]==0&&dp[j]+1>dp[i]){
                dp[i]=dp[j]+1;
                prev[i]=j;
                if(dp[i]>max){
                    max=dp[i];
                    store=i;
                }
            }
        }
    }
    
    List<Integer>list=new ArrayList<>();
    int i=store;
    while(i!=-1){
        list.add(nums[i]);
        i=prev[i];
    }
    Collections.reverse(list);
    return list;


  }
}