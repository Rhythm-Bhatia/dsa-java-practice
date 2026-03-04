class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        pq.addAll(map.values());
        while(!pq.isEmpty()){
            // int element=pq.poll();
            ArrayList<Integer>list=new ArrayList<>();
            int cycle=n+1;
            while(!pq.isEmpty()&&cycle!=0){
                int element=pq.poll();
                cycle--;
                count++;
                if((element-1)!=0){
                    list.add(element-1);
                }
            }
            while(cycle!=0&&list.size()>0){
                count++;
                cycle--;
            }
            for(int i=0;i<list.size();i++){
                pq.add(list.get(i));
            }
        }
        return count;
    }
}