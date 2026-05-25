class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(hand.length%groupSize!=0)return false;
        int number=hand.length/groupSize;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<hand.length;i++){
            pq.add(hand[i]);
        }
        List<Integer>pollinglist=new ArrayList<>();
        List<Integer>outlist=new ArrayList<>();
        boolean lencheck=false;
        while(!pq.isEmpty()){
            if(lencheck==false){
                lencheck=true;
                pollinglist.add(pq.poll());
                if(pollinglist.size()%groupSize==0){
                    lencheck=false;
                }
            }
            else if(pq.peek()-pollinglist.get(pollinglist.size()-1)==1){
                pollinglist.add(pq.poll());
               
                if(pollinglist.size()%groupSize==0){
                    lencheck=false;
                }
                for(int i=0;i<outlist.size();i++){
                    pq.add(outlist.get(i));
                }
                outlist.clear();
            }
            else{
                outlist.add(pq.poll());
            }
        }
        if(pollinglist.size()==n){
            return true;
        }
        return false;
    }
}