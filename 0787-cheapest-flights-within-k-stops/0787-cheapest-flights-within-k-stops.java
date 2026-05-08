class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){

            adj.get(flights[i][0]).add(
                new int[]{flights[i][1], flights[i][2]}
            );
        }

        int findistance[] = new int[n];

        for(int i = 0; i < n; i++){
            findistance[i] = (int)1e9;
        }

        findistance[src] = 0;

        Queue<int[]> pq = new LinkedList<>();

        // {stops, node, distance}
        pq.add(new int[]{0, src, 0});

        while(!pq.isEmpty()){

            int arr[] = pq.poll();

            int count = arr[0];
            int element = arr[1];
            int distance = arr[2];

            if(count > k){
                continue;
            }

            for(int[] a : adj.get(element)){

                int num = a[0];
                int dis = a[1];

                if(distance + dis < findistance[num]){

                    findistance[num] = distance + dis;

                    pq.add(new int[]{
                        count + 1,
                        num,
                        distance + dis
                    });
                }
            }
        }

        if(findistance[dst] == (int)1e9){
            return -1;
        }

        return findistance[dst];
    }
}