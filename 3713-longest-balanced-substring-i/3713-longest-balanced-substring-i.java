class Solution {
    public int longestBalanced(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer>map=new HashMap<>();
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int reference=map.get(s.charAt(j));
                int count=0;
                for(Map.Entry<Character,Integer>entry:map.entrySet()){
                    if(entry.getValue()==reference)count++;
                    else {
                        count=0;
                        break;
                    }

                }
                count=count*map.get(s.charAt(j));
                max=Math.max(max,count);
            }
        }
        return max;
    }
}