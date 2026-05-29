class Solution {
    class Pair{
        int first;
        char second;
        Pair(int first,char second){
            this.first=first;
            this.second=second;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        List<Character>list=new ArrayList<>();
        List<Pair>sidelist=new ArrayList<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->{
        return Integer.compare(y.first,x.first);
        });
        if(a!=0)pq.add(new Pair(a,'a'));
        if(b!=0)pq.add(new Pair(b,'b'));
        if(c!=0)pq.add(new Pair(c,'c'));
        boolean flag=false;
        Pair p=pq.poll();
        char last=p.second;
        list.add(last);
        if((p.first-1)!=0){
            pq.add(new Pair(p.first-1,last));
        }
        while(!pq.isEmpty()){
            Pair pp=pq.poll();
            int fir=pp.first;
            char sec=pp.second;
            if(sec!=last){
                list.add(sec);
                if((fir-1)!=0){
                    pq.add(new Pair(fir-1,sec));
                }
                last=sec;
                flag=false;
            }
            else if(sec==last&&flag==false){
                flag=true;
                list.add(sec);
                if((fir-1)!=0){
                    pq.add(new Pair(fir-1,sec));
                }
            }
            else{
                sidelist.add(pp);
            }
            if(!sidelist.isEmpty()&&sidelist.get(0).second!=sec){
                pq.add(sidelist.get(0));
                sidelist.clear();
            }
        }
        String ans=new String();
        for(int i=0;i<list.size();i++){
            ans+=""+list.get(i);
        }
        return ans;
    }
}