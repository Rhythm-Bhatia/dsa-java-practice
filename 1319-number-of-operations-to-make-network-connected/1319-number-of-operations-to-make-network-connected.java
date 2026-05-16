class Solution {
    class disjointSet{
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
                parent.set(uup,vup);
                size.set(vup,size.get(vup)+size.get(uup));
            }
            else{
                parent.set(vup,uup);
                size.set(uup,size.get(uup)+size.get(vup));
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        disjointSet ds=new disjointSet(n);
        for(int i=0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            ds.unionbysize(a,b);
            

        }
        int proviences=0;
        for(int i=0;i<n;i++){
            if(ds.ultimateparent(i)==i){
                proviences++;
            }
        }
        if(connections.length>=n-1){
            return proviences-1;
        }
        return -1;

    }
}