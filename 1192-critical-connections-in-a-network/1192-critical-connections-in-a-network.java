class Solution {
    int timer=1;
    
    int tin[];
    int low[];
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        tin=new int[n];
        low=new int [n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int a=connections.get(i).get(0);
            int b=connections.get(i).get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        List<List<Integer>>bridges=new ArrayList<>();
        boolean visited[]=new boolean[n];
        dfs(0,-1,visited,adj,bridges);
        return bridges;

    }
    public void dfs(int node,int parent,boolean[]visited,List<List<Integer>>adj,List<List<Integer>>bridges){
        tin[node]=timer;
        low[node]=timer;
        timer++;
        visited[node]=true;
        for(int it:adj.get(node)){
            if(visited[it]==false){
                dfs(it,node,visited,adj,bridges);
                low[node]=Math.min(low[it],low[node]);
                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(node,it));
                }
            }
            else{
                if(it!=parent){
                    low[node]=Math.min(low[node],tin[it]);
                }
            }
        }
    }
}