class Pair{
    int capitalss;
    int profitss;
    Pair(int capitalss,int profitss){
        this.capitalss=capitalss;
        this.profitss=profitss;
    }


}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
         PriorityQueue<Pair>minHeap=new PriorityQueue<>(new Comparator <Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                return Integer.compare(p1.capitalss,p2.capitalss);
            }
         });
         for(int i=0;i<profits.length;i++){
            minHeap.offer(new Pair(capital[i],profits[i]));
         }
         PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
         while(k>0){
            while(!minHeap.isEmpty()&&minHeap.peek().capitalss<=w){
                maxHeap.offer(minHeap.poll().profitss);
            }
            if(maxHeap.isEmpty())break;
            w=w+maxHeap.poll();

            k--;
         }

         return w;
    }
}