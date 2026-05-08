class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return a[1]-b[1];
        });
        int distance[][]=new int[n][n];
        if(grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=(int)1e9;
            }
        }
        distance[0][0]=1;
        pq.add(new int[]{1,0,0});

        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int dis=arr[0];
            int x=arr[1];
            int y=arr[2];
            int array[][]={{x-1,y-1},{x,y-1},{x+1,y-1},{x+1,y},{x+1,y+1},{x,y+1},{x-1,y+1},{x-1,y}};
            for(int[]a:array){
                if(a[0]<0||a[0]>=grid.length||a[1]<0||a[1]>=grid.length){
                    continue;
                }
                if(grid[a[0]][a[1]]==1){
                    continue;
                }
                
                if(distance[a[0]][a[1]]>dis+1){
                    distance[a[0]][a[1]]=dis+1;
                    pq.add(new int[]{dis+1,a[0],a[1]});
                }

            }
        }
        if(distance[n-1][n-1]==(int)1e9){
            return -1;
        }
        return distance[n-1][n-1];
    }
}