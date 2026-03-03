class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i=0;
        int j=0;
        Arrays.sort(s);
        Arrays.sort(g);
        int count=0;
        while(i<s.length &&j<g.length){
            if(s[i]>=g[j]){
                count++;
                i++;
                j++;
            }
            else{
                i++;
            }

        }
        return count;
    }
}