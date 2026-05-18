class Solution {
    public static class disjointSet{
        public List<Integer>size=new ArrayList<>();
        public List<Integer>parent=new ArrayList<>();

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
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        boolean zeropresent=false;
        disjointSet ds=new disjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int arrrow[]={-1,0,1,0};
                int arrcol[]={0,1,0,-1};
                if(grid[i][j]==0){
                    
                    zeropresent=true;
                    continue;
                }
                for(int k=0;k<4;k++){
                    int newrow=i+arrrow[k];
                    int newcol=j+arrcol[k];
                    if(isvalid(newrow,newcol,n)&&grid[newrow][newcol]==1){
                        int updatedelement=i*n+j;
                        int updatedadjelement=newrow*n+newcol;
                        ds.unionbysize(updatedelement,updatedadjelement);
                    }
                }
            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int arrrow[]={-1,0,1,0};
                int arrcol[]={0,1,0,-1};
                if(grid[i][j]==1)continue;
                Set<Integer>set=new HashSet<>();
                for(int k=0;k<4;k++){
                    int newrow=i+arrrow[k];
                    int newcol=j+arrcol[k];
                    if(isvalid(newrow,newcol,n)&&grid[newrow][newcol]==1){
                        // int updatedelement=i*n+j;
                        int updatedadjelement=newrow*n+newcol;
                        int p=ds.ultimateparent(updatedadjelement);
                        set.add(p);

                    }
                }
                int len=0;;
                List<Integer> list =new ArrayList<>(set);
                for(int l=0;l<list.size();l++){
                    len+=ds.size.get(list.get(l));
                }
                max=Math.max(len+1,max);

            }
        }
        if(zeropresent==false){
            return n*n;
        }
        return max;

    }
    public boolean isvalid(int i,int j,int n){
        if(i<0||j<0||i>=n||j>=n){
            return false;
        }
        return true;
    }
}