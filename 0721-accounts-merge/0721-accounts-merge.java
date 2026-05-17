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
                size.set(vup,size.get(uup)+size.get(vup));
                parent.set(uup,vup);
            }
            else{
                size.set(uup,size.get(vup)+size.get(uup));
                parent.set(vup,uup);
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n=accounts.size();
        HashMap<String,Integer>map=new HashMap<>();
        disjointSet ds=new disjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(map.containsKey(accounts.get(i).get(j))){
                    ds.unionbysize(i,map.get(accounts.get(i).get(j)));
                }
                else{
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }
        List<List<String>>temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new ArrayList<>());
        }
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            String a=entry.getKey();
            int b=entry.getValue();
            int c=ds.ultimateparent(b);
            temp.get(c).add(a);
        }
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(temp.get(i).isEmpty()){
                continue;
            }
            Collections.sort(temp.get(i));
            List<String>listt=new ArrayList<>();
            listt.add(accounts.get(i).get(0));
            for(int j=0;j<temp.get(i).size();j++){
                listt.add(temp.get(i).get(j));
            }
            ans.add(listt);
        }
        return ans;
        
        
    }
}