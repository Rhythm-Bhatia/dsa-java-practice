class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1&&i!=j){
                    list.get(i).add(j);
                }

            }
        }
        boolean visited[]=new boolean[list.size()];
        int num=0;
        for(int i=0;i<list.size();i++){
            if(visited[i]==false){
                dfs(list,visited,i);
                num++;
            }
        }
        return num;
    }
    void dfs(List<List<Integer>>list,boolean[]visited,int i){
        visited[i]=true;
        for(int a:list.get(i)){
            if(visited[a]==false){
                dfs(list,visited,a);
            }
        }

    }
}