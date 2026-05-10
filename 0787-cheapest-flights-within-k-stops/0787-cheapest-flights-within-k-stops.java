class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        if(src==dst)return 0;
        List<List<int[]>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            list.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{src,0,0});
        int distance[]=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int element=arr[0];
            int distancee=arr[1];
            int num=arr[2];
            if(num>k){
                q.poll();
                continue;
            }
            for(int []a:list.get(element)){
                int ele=a[0];
                int dis=a[1];
                if(distance[ele]>dis+distancee){
                    distance[ele]=dis+distancee;
                    q.add(new int[]{ele,dis+distancee,num+1});
                }
            }
        }
        if(distance[dst]==(int)1e9)return -1;
        return distance[dst];
    }
}