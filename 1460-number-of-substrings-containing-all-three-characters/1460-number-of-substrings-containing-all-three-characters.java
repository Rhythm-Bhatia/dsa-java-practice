//BRUTE FORCE
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int count=0;
//         for(int i=0;i<s.length();i++){
//             int hash[]=new int[3];
//             for(int j=i;j<s.length();j++){
//                 hash[s.charAt(j)-'a']=1;
//                 if(hash[0]+hash[1]+hash[2]==3){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
//slight optimization
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int count=0;
//         for(int i=0;i<s.length();i++){
//             int hash[]=new int[3];
//             for(int j=i;j<s.length();j++){
//                 hash[s.charAt(j)-'a']=1;
//                 if(hash[0]+hash[1]+hash[2]==3){
//                     count=count+s.length()-j;
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution{
    public int numberOfSubstrings(String s){
        int r=0;
        int count=0;
        int n=s.length();
        int hash[]=new int[3];
        Arrays.fill(hash,-1);
        while(r<n){
            hash[s.charAt(r)-'a']=r;
            int min=Integer.MAX_VALUE;
            if(hash[0]!=-1&&hash[1]!=-1&&hash[2]!=-1){
                for(int i=0;i<3;i++){
                    if(hash[i]<min){
                        min=hash[i];
                    }

                }
                count=count+min+1;
            }
            r++;
        }
        return count;
    }
}