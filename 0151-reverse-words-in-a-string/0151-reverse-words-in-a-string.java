class Solution {
    public String reverseWords(String s) {
        s=s.trim().replaceAll("\\s+"," ");
        String[]words=s.split(" ");
        int n=words.length;
        for(int i=0;i<n/2;i++){
            String temp=words[i];
            words[i]=words[n-i-1];
            words[n-i-1]=temp;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(words[i]);
            if(i!=n-1)sb.append(" ");
        }


        return sb.toString();

        

    }
    
}