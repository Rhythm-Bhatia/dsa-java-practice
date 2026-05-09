class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            list.get(roads[i][0]).add(new long[]{roads[i][1],roads[i][2]});
            list.get(roads[i][1]).add(new long[]{roads[i][0], roads[i][2]});
        }
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->{
            return Long.compare(a[1],b[1]);
        });
        long ans[]=new long[n];
        int ways[] = new int[n];
        ways[0]=1;
        Arrays.fill(ans,Long.MAX_VALUE);
        ans[0]=0;

        int mod=1000000007;

        pq.add(new long[]{0,0});
      
        while(!pq.isEmpty()){
            long arr[]=pq.poll();
            int element=(int)arr[0];
            long distance=arr[1];
            for(long[]a:list.get(element)){
                long dis=a[1];
                int ele=(int)a[0];
                if(ans[ele]>dis+distance){
                    ans[ele]=dis+distance;
                    ways[ele]=ways[element];
                    pq.add(new long[]{ele,dis+distance});
                }
                else if(ans[ele]==dis+distance){
                    ways[ele]=(ways[ele]+ways[element])%mod;
                }
            }
        }
        return ways[n-1];
    }
}