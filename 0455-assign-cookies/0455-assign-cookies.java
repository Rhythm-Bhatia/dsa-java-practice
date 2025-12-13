class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int j=0;
        for(int i=0;i<g.length;i++){
            while(j<s.length){
                if(s[j]>=g[i]){
                    count++;
                    j++;
                    break;
                }
                else{
                    j++;
                }
                
            }
        }
        return count;
    }
}