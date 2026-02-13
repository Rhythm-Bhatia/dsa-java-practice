class Solution {
    public int longestBalanced(String s) {
        //  char a=s.charAt(0);
         int count=1;
         int max=Integer.MIN_VALUE;
         for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }
            else{
                count=1;
            }
            max=Math.max(max,count);
         }
         max=Math.max(max,count);
         int countAB=longfor2('a','b',s);
         int countBC=longfor2('b','c',s);
         int countCA=longfor2('c','a',s);
         max=Math.max(countAB,max);
         max=Math.max(countBC,max);
         max=Math.max(countCA,max);
         

         int countA=0;
         int countB=0;
         int countC=0;
         Map<String,Integer>map=new HashMap<>();
         map.put("0_0", -1);
         for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                countA++;
            }
            else if(s.charAt(i)=='b'){
                countB++;
            }
            else {
                countC++;
            }
            if(countA==countB&&countB==countC){
                max=Math.max(max,countA+countB+countC);
            }
            int diff1 = countA - countB;
            int diff2 = countB - countC;

            String convert=diff1+"_"+diff2;
            if(!map.containsKey(convert)){
                map.put(convert,i);
            }            
            else{
                max=Math.max(max,i-map.get(convert));
            }

         }
         return max;



    }
    public int longfor2(char x,char y,String s){
        int max=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1); 
        int countx=0;
        int county=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x)countx++;
            else if(s.charAt(i)==y)county++;
            else{
                countx=0;
                county=0;
                map=new HashMap<>();
                continue;

            }
            if(countx==county){
                max=Math.max(max,countx+county);
            }
            int diff=countx-county;
            if(!map.containsKey(diff)){
                map.put(diff,i);

            }
            else {
                max=Math.max(max,i-map.get(diff));
            }

        }
        return max;
    }
}