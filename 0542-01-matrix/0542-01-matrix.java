class Solution {
    public int[][] updateMatrix(int[][] mat) {
        boolean visited[][]=new boolean[mat.length][mat[0].length];
        int dis[][]=new int[mat.length][mat[0].length];
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        while(!queue.isEmpty()){
            int arr[]=queue.poll();
            int i=arr[0];
            int j=arr[1];
            int distance=arr[2];
            dis[i][j]=distance;

            if(j+1<mat[0].length&&visited[i][j+1]==false){
                queue.add(new int[]{i,j+1,distance+1});
                visited[i][j+1]=true;
            }
            if(i+1<mat.length&&visited[i+1][j]==false){
                queue.add(new int[]{i+1,j,distance+1});
                visited[i+1][j]=true;
            }
            if(j-1>=0&&visited[i][j-1]==false){
                queue.add(new int[]{i,j-1,distance+1});
                visited[i][j-1]=true;
            }
            if(i-1>=0&&visited[i-1][j]==false){
                queue.add(new int[]{i-1,j,distance+1});
                visited[i-1][j]=true;
            }


        }
        return dis;
    }
}