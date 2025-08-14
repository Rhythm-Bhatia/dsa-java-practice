// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n=s.length();
//         int count=0;
//         Set<Character>set=new LinkedHashSet<>();
//         for(int i=0;i<n;i++){
//             while(set.contains(s.charAt(i))){
//                 char first = set.iterator().next(); 
//                 set.remove(first); 
//             }
//             set.add(s.charAt(i));
//             count=Math.max(count,set.size());
//         }
//         return count;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
