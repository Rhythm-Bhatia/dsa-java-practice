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
                int freqCompare=Integer.compare(p1.freq,p2.freq);
                if(freqCompare!=0)return freqCompare;
                //optinal tie breaker if frequencues are same the do by value
                return Integer.compare(p1.element,p2.element);
            }
        });
        //add all elements as pair and return top k
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            heap.offer(new pair(entry.getKey(),entry.getValue()));
            if(heap.size()>k){
                heap.poll();
            }
        }
        //extract elements from heap
        int result[]=new int[k];
        for(int i=k-1;i>=0;i--){
            result[i]=heap.poll().element;
        }
        return result;

        

    }
}