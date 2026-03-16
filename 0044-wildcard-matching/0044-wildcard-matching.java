class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][]=new Boolean[s.length()+1][p.length()+1];
        return match(s,p,0,0,dp);
    }
    private  boolean match(String s,String p,int i,int j,Boolean dp[][]){
        if(i==s.length()&&j==p.length()){
            return true;
        }
        else if(i==s.length()&&j!=p.length()){
            for(int x=j;x<p.length();x++){
                if(p.charAt(x)!='*'){
                    return false;
                }
            }
            return true;
        }
        else if(j==p.length())return false;
        if(dp[i][j]!=null)return dp[i][j];

        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
            return dp[i][j]=match(s,p,i+1,j+1,dp);
        }
        else if(p.charAt(j)=='*'){
            return dp[i][j]=match(s,p,i+1,j,dp)||match(s,p,i+1,j+1,dp)||match(s,p,i,j+1,dp);
        }
        else{
            return dp[i][j]=false;
        }
    }
}