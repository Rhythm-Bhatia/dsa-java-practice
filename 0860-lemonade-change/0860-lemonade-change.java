class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<bills.length;i++){
            map.put(bills[i],map.getOrDefault(bills[i],0)+1);
            if(bills[i]==10){
                if(map.get(5)!=null&&map.get(5)>0){
                    map.put(5,map.get(5)-1);
                    continue;
                }
                else return false;
            }
            else if(bills[i]==20){
                if(map.get(5)!=null&&map.get(10)!=null&&map.get(5)>0&&map.get(10)>0){
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                    continue;
                }
                else if(map.get(5)!=null&&map.get(5)>=3){
                    map.put(5,map.get(5)-3);
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
        
    }
}