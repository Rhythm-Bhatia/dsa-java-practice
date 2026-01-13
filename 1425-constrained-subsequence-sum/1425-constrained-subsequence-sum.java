class Pair{
    int element;
    int index;

    Pair(int element,int index){
        this.element=element;
        this.index=index;
    }
}
class Solution {
    
    public int constrainedSubsetSum(int[] nums, int k) {
        int arr[]=new int[nums.length];
        // int max=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            new Comparator <Pair>(){
                public int compare(Pair a,Pair b){
                    return Integer.compare(b.element,a.element);
                }
            }
        );
        arr[0] = nums[0];
        pq.add(new Pair(arr[0], 0));
        int max = arr[0];
        for(int i=1;i<nums.length;i++){
            while(!pq.isEmpty()&&i-pq.peek().index>k){
                pq.poll();
            }
            int neww=0;
            if(!pq.isEmpty()){
                neww=pq.peek().element;
            }
            arr[i]=Math.max(nums[i],nums[i]+neww);
            pq.add(new Pair(arr[i],i));
            max=Math.max(max,arr[i]);
        }
        return max;
        
        
    }
}