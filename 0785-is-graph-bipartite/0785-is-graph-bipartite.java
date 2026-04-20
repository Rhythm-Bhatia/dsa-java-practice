class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean ans=true;
        boolean visited[]=new boolean[graph.length];
        int pathvisited[]=new int[graph.length];
        for(int i=0;i<pathvisited.length;i++){
            pathvisited[i]=-1;
        }
        Queue<Integer>queue=new LinkedList<>();
        
        
        for(int i=0;i<graph.length;i++){
            if(visited[i]!=true){
                queue.add(i);
                pathvisited[i]=0;
                visited[i]=true; 
                ans=ans&&bfs(graph,visited,pathvisited,queue);
            }
        }
        return ans;
    }
    private boolean bfs(int[][]graph,boolean[]visited,int[] pathvisited,Queue<Integer>queue){
        while(!queue.isEmpty()){
            int element=queue.poll();
            
            for(int j=0;j<graph[element].length;j++){
                int a=graph[element][j];
                if(visited[a]!=true){
                    queue.add(a);
                    visited[a]=true;
                    if(pathvisited[element]==0){
                        pathvisited[a]=1;
                    }
                    else if(pathvisited[element]==1){
                        pathvisited[a]=0;
                    }
                }
                else if(visited[a]==true&&pathvisited[element]==pathvisited[a]){
                    return false;
                }
                
            }
        }
        return true;
    }
}