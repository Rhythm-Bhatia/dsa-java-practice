class Solution {
    public int characterReplacement(String s, int k) {
        int hash[]=new int[26];
        int l=0;
        int r=0;
        int max=0;
        int maxFreq=0;
        int n=s.length();
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(hash[s.charAt(r)-'A'],maxFreq);
            while((r-l+1)-maxFreq>k){
                maxFreq=0;
                hash[s.charAt(l)-'A']--;
                for(int i=0;i<26;i++){
                    if(hash[i]>maxFreq){
                        maxFreq=hash[i];
                    }

                }
                l++;
            }
            
            max=Math.max(r-l+1,max);

            
            r++;
        }
        return max;
    }
}