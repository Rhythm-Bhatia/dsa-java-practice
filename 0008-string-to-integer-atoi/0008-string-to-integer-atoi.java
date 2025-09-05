class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        StringBuilder sb=new StringBuilder(s);
        StringBuilder ans=new StringBuilder();
        if(s.length()==0)return 0;
        if(sb.charAt(0)=='-'){
            ans.append('-');
            sb.deleteCharAt(0);

        }
        else if(sb.charAt(0)=='+'){
            sb.deleteCharAt(0);
        }
        while(sb.length() > 0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        long num=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)>='0' && sb.charAt(i)<='9'){
                ans.append(sb.charAt(i));
                try {
                    num = Long.parseLong(ans.toString());
                } catch (NumberFormatException e) {
                    // if it overflows even long, clamp directly
                    return (ans.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;


            }
            else{
                break;
            }
        }
        if(ans.length()==0 ||ans.toString().equals('-'))return 0;
        // return Integer.parseInt(ans.toString());
        return (int)num;

    }
}