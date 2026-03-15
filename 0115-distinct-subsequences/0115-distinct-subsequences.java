class Solution {
    public int numDistinct(String s, String t) {
        Integer dp[][]=new Integer[s.length()+1][t.length()+1];

        return distinct(s,t,0,0,dp);
    }
    private int distinct(String s,String t,int i,int j,Integer dp[][]){
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        int take=0;
        int nottake=0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
             take=distinct(s,t,i+1,j+1,dp)+distinct(s,t,i+1,j,dp);
        }
        else{
            nottake=distinct(s,t,i+1,j,dp);
        }
        return dp[i][j]=take+nottake;

    }
}