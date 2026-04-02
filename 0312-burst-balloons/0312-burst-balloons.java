// import java.util.*;

// class Solution {
//     public int maxCoins(int[] nums) {
//         Map<String, Integer> dp = new HashMap<>();
//         return solve(nums, dp);
//     }

//     private int solve(int[] nums, Map<String, Integer> dp) {
//         if (nums.length == 0) return 0;

//         // build key
//         String key = "";
//         for (int i = 0; i < nums.length; i++) {
//             key += nums[i] + ",";
//         }

//         if (dp.containsKey(key)) return dp.get(key);

//         int max = 0;

//         for (int i = 0; i < nums.length; i++) {

//             int left = (i - 1 >= 0) ? nums[i - 1] : 1;
//             int right = (i + 1 < nums.length) ? nums[i + 1] : 1;

//             int coins = left * nums[i] * right;

//             // create new array without nums[i]
//             int[] newArr = new int[nums.length - 1];
//             int index = 0;

//             for (int j = 0; j < nums.length; j++) {
//                 if (j == i) continue;
//                 newArr[index++] = nums[j];
//             }

//             int total = coins + solve(newArr, dp);
//             max = Math.max(max, total);
//         }

//         dp.put(key, max);
//         return max;
//     }
// }

class Solution {
    public int maxCoins(int[] nums) {
        int num[]=new int[nums.length+2];
        num[0]=1;
        num[num.length-1]=1;
        for(int i=1;i<num.length-1;i++){
            num[i]=nums[i-1];

        }
        Integer dp[][]=new Integer[num.length][num.length];
        return solve(num,1,nums.length,dp);
    }
    private int solve(int num[],int i,int j,Integer[][]dp){
        if(i>j)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int index=i;index<=j;index++){
            int temp=num[index]*num[i-1]*num[j+1];
            int ans=temp+solve(num,i,index-1,dp)+solve(num,index+1,j,dp);
            if(ans>max)max=ans;
        }
        return dp[i][j]=max;
    }
}