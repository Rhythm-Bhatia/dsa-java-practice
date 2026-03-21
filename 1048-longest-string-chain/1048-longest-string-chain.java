class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int max=1;
        int dp[]=new int[words.length];
        Arrays.fill(dp,1);
        for(int i=0;i<words.length;i++){
            for(int j=i-1;j>=0;j--){
                if(isfunction(words[i],words[j])==true && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    max=Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
    public boolean isfunction(String a,String b){
        if(a.length()-b.length()!=1){
            return false;
        }
        int i=0;
        int j=0;
        int count=0;
        while(i!=a.length()&&j!=b.length()){
            if(a.charAt(i)!=b.charAt(j)){
                if(count==0){
                    i++;
                    count++;
                }
                else{
                    return false;
                }
            }
            else{
                i++;
                j++;
            }
        }
        return true;
    }
}