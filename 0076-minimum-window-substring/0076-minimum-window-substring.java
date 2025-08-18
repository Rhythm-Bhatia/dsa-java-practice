class Solution {
    public String minWindow(String s, String t) {
        int hash[]=new int[256];
       
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }
        int l=0;
        int r=0;
        int count=0;
        int n=s.length();
        int length=0;
        int left=-1;
        int right=-1;
        int min=Integer.MAX_VALUE;
        while(r<n){
            if(hash[s.charAt(r)]>0)count=count+1;
            hash[s.charAt(r)]--;
            
            while(count==t.length()){
                length=r-l+1;
                if(length<min){
                    min=length;
                    left=l;
                    right=r;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0)count=count-1;
                l++;

            }
            r++;
        }
        if(left==-1){
            return "";

        }
        else{
            StringBuilder ans=new StringBuilder();

            for(int i=left;i<=right;i++){
                ans.append(s.charAt(i));
            }
            return ans.toString();
        }
    }
}