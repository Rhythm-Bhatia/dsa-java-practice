class Solution {
    static class disjointSet{
        List<Integer>parent=new ArrayList<>();
        List<Integer>size=new ArrayList<>();

        disjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int ultimateparent(int node){
            if(node==parent.get(node)){
                return node;
            }
            int udp=ultimateparent(parent.get(node));
            parent.set(node,udp);
            return udp;
        }
        public void unionbysize(int u,int v){
            int uup=ultimateparent(u);
            int vup=ultimateparent(v);
            if(uup==vup)return;
            if(size.get(uup)<size.get(vup)){
                size.set(vup,size.get(vup)+size.get(uup));
                parent.set(uup,vup);
            }
            else{
                size.set(uup,size.get(uup)+size.get(vup));
                parent.set(vup,uup);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int rowlen=0;
        int collen=0;
        for(int i=0;i<stones.length;i++){
            int a=stones[i][0];
            int b=stones[i][1];
            rowlen=Math.max(rowlen,a);
            collen=Math.max(collen,b);
        }

        //  int rows[]=new int[rowlen];
        //  int cols[]=new int[collen];
        //  for(int i=0;i<rowlen;i++){
        //     rows[i]=i;
        //     cols[i]=i+rowlen;

        //  }
        rowlen=rowlen+1;
        collen=collen+1;
        Map<Integer,Integer>map=new HashMap<>();
        disjointSet ds=new disjointSet(rowlen+collen);
        for(int i=0;i<stones.length;i++){
            int a=stones[i][0];
            int b=stones[i][1]+rowlen;

            ds.unionbysize(a,b);
            map.put(a,1);
            map.put(b,1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(ds.ultimateparent(entry.getKey())==entry.getKey()){
                count++;
            }
        }
        return stones.length-count;
         
         
    }
}