class Solution {

    public int minCut(String s) {
        Integer[]dp=new Integer[s.length()+1];
        dp[s.length()]=0;
        for(int i=s.length()-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(isPalindrome(i,j,s)){
                    int temp=1+dp[j+1];
                    min=Math.min(min,temp);
                }
            }
            dp[i]=min;
        
        
        }
        return dp[0]-1;
    }
    // private int solve(String s,int i,Integer[]dp){
    //     if(i>=s.length())return 0;
    //     if(dp[i]!=null)return dp[i];
        
    // }
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