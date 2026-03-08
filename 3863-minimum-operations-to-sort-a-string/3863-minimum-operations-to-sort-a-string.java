// class Solution {
//     public int minOperations(String s) {
        
//         char arr[]=s.toCharArray();
//         Arrays.sort(arr);
//         String sorted=new String(arr);
//         if(!s.equals(sorted)&&s.length()==2){
//             return -1;
//         }
//         if(s.equals(sorted)){
//             return 0;
//         }
        
//         if(s.charAt(0)==arr[0] || s.charAt(s.length()-1)==arr[arr.length-1]){
//             return 1;
//         }
        
//         if(s.charAt(0)==arr[arr.length-1]&&s.charAt(s.length()-1)==arr[0]){
//             return 3;
//         }
//         else {
//             return 2;
//         }
        
//     }
// }
import java.util.*;

class Solution {
    public int minOperations(String s) {

        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        if(!s.equals(sorted) && s.length()==2){
            return -1;
        }

        if(s.equals(sorted)){
            return 0;
        }

        int ans;

        if(s.charAt(0)==arr[0] || s.charAt(s.length()-1)==arr[arr.length-1]){
            ans = 1;
        }
        else if(s.charAt(0)==arr[arr.length-1] && s.charAt(s.length()-1)==arr[0]){
            ans = 3;
        }
        else{
            ans = 2;
        }

        // count occurrences of smallest and largest characters
        int firstCount = 0;
        int lastCount = 0;

        char first = arr[0];
        char last = arr[arr.length-1];

        for(char c : arr){
            if(c == first) firstCount++;
            if(c == last) lastCount++;
        }

        if(ans ==3  && (firstCount > 1 || lastCount > 1)){
            ans--;
        }

        return ans;
    }
}