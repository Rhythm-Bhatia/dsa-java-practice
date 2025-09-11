class Solution {
     class pair{
        int element;
        int freq;
        pair(int element,int freq){
            this.element=element;
            this.freq=freq;
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        //count frequency
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //create min heap
        PriorityQueue<pair>heap=new PriorityQueue<>(new Comparator <pair>(){
            @Override
            public int compare(pair p1,pair p2){
                int freqCompare=Integer.compare(p2.freq,p1.freq);
                if(freqCompare!=0)return freqCompare;
                //optinal tie breaker if frequencues are same the do by value
                return Integer.compare(p1.element,p2.element);
            }
        });
        //add all elements as pair and return top k
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            heap.offer(new pair(entry.getKey(),entry.getValue()));
            
        }
        //extract elements from heap
        int result[]=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll().element;
        }
        return result;
    }
}
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
//         PriorityQueue <Integer> pq=new PriorityQueue<Integer>((a,b)->(map.get(a)-map.get(b)));
        
//         for(int i=0;i<nums.length;i++){
            
//             map.put(nums[i],1+map.getOrDefault(nums[i],0));
//         }
        
//         for(Integer key:map.keySet()){
//             pq.add(key);
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
        
//         int[] res=new int[k];
//         int i=0;
//         while(pq.size()>0){
//            res[i++]=pq.poll();
           
//         }
//         return res;
//     }
// }