class Solution {
    public int reverseBits(int n) {
        String input=String.format("%32s",Integer.toBinaryString(n)).replace(' ','0');
        
        StringBuilder sb=new StringBuilder(input);
        sb.reverse();
        String s=sb.toString();
        int ans=Integer.parseInt(s,2);
        return ans;
    }
}