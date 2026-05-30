class Solution {
    class Pair{
        int frequency;
        char element;
        Pair(int frequency,char element){
            this.frequency=frequency;
            this.element=element;
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer>map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b.frequency,a.frequency);
        });
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
        }
        List<Character>list=new ArrayList<>();
        
        Pair last=pq.poll();
        list.add(last.element);
        while(!pq.isEmpty()){
            if(pq.peek().element!=last.element){
                int f=last.frequency;
                char c=last.element;
                last=pq.poll();
                list.add(last.element);
                if(f-1!=0){
                    pq.add(new Pair(f-1,c));
                }

            }
            else{
                return "";
            }
        }
        if(last.frequency>1){
            return "";
        }
        String ans="";
        for(int i=0;i<list.size();i++){
            ans=ans+list.get(i);
        }
        return ans;
        
        
    }
}