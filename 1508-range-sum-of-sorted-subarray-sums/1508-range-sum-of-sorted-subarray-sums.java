class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                pq.add(sum);
                if(pq.size()>right){
                    pq.poll();
                }
            }
        }
        int out=right-left+1;
        long ans=0;
        for(int i=0;i<out;i++){
            ans+=pq.poll();
        }
        int MOD = 1000000007;
        return (int)(ans%MOD);

    }
}