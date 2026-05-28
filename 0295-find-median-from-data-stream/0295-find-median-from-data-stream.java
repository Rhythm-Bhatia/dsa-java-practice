//Follow up:

//If all integer numbers from the stream are between 0 and 100, how would you optimize it?
//If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
class MedianFinder {
    PriorityQueue<Integer>pq1;
    PriorityQueue<Integer>pq2;

    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq1.add(num);
        if(pq1.size()>pq2.size()+1){
            pq2.add(pq1.poll());
        }
        else if(!pq2.isEmpty()&&pq1.peek()>pq2.peek()){
            int a=pq1.poll();
            int b=pq2.poll();
            pq2.add(a);
            pq1.add(b);
        }
        
    }
    
    public double findMedian() {
        int len=pq1.size()+pq2.size();

        
        if(len%2==0){
            return (pq1.peek()+pq2.peek())/2.0;
        }
        else{
            return pq1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */