class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int r=0;
        int count=0;
        

        Set<Character>set=new LinkedHashSet<>();
        for(int i=0;i<n;i++){
            while(set.contains(s.charAt(i))){
                char first = set.iterator().next(); 
                set.remove(first); 

            }
            
            set.add(s.charAt(i));
            count=Math.max(count,set.size());

            


       }
       return count;

       
    }
}