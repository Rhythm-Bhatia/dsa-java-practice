class Solution {

    public int minCut(String s) {
        Integer[]dp=new Integer[s.length()];
        return solve(s,0,dp)-1;
    }
    private int solve(String s,int i,Integer[]dp){
        if(i>=s.length())return 0;
        if(dp[i]!=null)return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                int temp=1+solve(s,j+1,dp);
                min=Math.min(min,temp);
            }
        }
        return dp[i]=min;
    }
    private boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
                
            }
            i++;
            j--;

        }
        return true;
    }

    
}