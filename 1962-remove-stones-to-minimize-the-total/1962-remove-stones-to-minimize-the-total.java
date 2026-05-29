class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
            
        }
        for(int i=0;i<k;i++){
            int num=pq.poll();
            int a=(int)Math.floor(num/2.0);
            pq.add(num-a);
        }
        int sum=0;
        int size=pq.size();
        for(int i=0;i<size;i++){
            sum+=pq.poll();
        }
        return sum;
    }
}