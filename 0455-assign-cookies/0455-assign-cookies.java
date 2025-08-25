class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0||g.length==0){
            return 0;
        }
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        List<Integer>slist=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            slist.add(s[i]);
        }

        for(int i=0;i<g.length;i++){
            int greedy=g[i];
            if(slist.size()==0)break;
            if(greedy>slist.get(slist.size()-1))break;
            for(int j=0;j<slist.size();j++){
                if(slist.get(j)>=greedy){
                    count++;
                    slist.remove(j);
                    break;
                }

            }
        }
        return count;
    }
}