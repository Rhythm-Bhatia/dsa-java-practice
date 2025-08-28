class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer,PriorityQueue<Integer>>minHeap=new HashMap<>();
        Map<Integer,PriorityQueue<Integer>>maxHeap=new HashMap<>();
        

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int key=i-j;
                if(key<0){
                    minHeap.putIfAbsent(key,new PriorityQueue<>());
                    minHeap.get(key).offer(grid[i][j]);
                }
                else{
                    maxHeap.putIfAbsent(key,new PriorityQueue<>(Collections.reverseOrder()));
                    maxHeap.get(key).offer(grid[i][j]);
                }
            }

        }

        //now i will fill the grid again
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int key=i-j;
                if(key<0){
                    grid[i][j]=minHeap.get(key).poll();
                }
                else{
                    grid[i][j]=maxHeap.get(key).poll();
                }
            }
        }
        return grid;

    }
}