class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        char arr[]=s.toCharArray();
        int max=0;
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
                
            }
            else{
                int till=map.get(arr[i]);
                for(int j=k;j<=till;j++){
                    map.remove(arr[j]);

                }
                k=till+1;
                map.put(arr[i],i);
            }
            max=Math.max(map.size(),max);

            
        }
        return max;
    }
}