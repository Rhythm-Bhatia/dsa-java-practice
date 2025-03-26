class Solution {
    public int romanToInt(String s) {
        int max=0;
        Map<Character,Integer> mp= new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        for(int i=0;i<s.length()-1;i++){
            int a=mp.get(s.charAt(i));
            if(a<mp.get(s.charAt(i+1))){
                a=a*-1;
                
            }
            max=max+a;
        }
        max=max+mp.get(s.charAt(s.length()-1));
        return max;
    }
}