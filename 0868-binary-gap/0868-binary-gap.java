class Solution {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        int count=0;
        int max=0;
        int previous=0;
        for(int i=0;i<s.length();i++){
            if(count==0&&s.charAt(i)=='1'){
                count++;
                previous=i;
            }
            else if(count!=0&&s.charAt(i)=='1'){
                max=Math.max(max,i-previous);
                previous=i;
            }

        }
        return max;
    }
}