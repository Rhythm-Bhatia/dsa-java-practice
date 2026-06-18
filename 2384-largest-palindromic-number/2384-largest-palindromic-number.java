class Solution {
    public String largestPalindromic(String num) {
         TreeMap<Character,Integer>map=new TreeMap<>(Collections.reverseOrder());
         for(int i=0;i<num.length();i++){
            map.put(num.charAt(i),map.getOrDefault(num.charAt(i),0)+1);
         }
         String str1="";
         String str2="";
         char max='#';
         for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char key=entry.getKey();
            int value=entry.getValue();
            if(value%2!=0&&max=='#'){
                max=key;

            }
            int count=value/2;
            while(count!=0){
                str1=str1+key;
                str2=key+str2;
                count--;
            }
         }
         if(max!='#'){
            str1=str1+max;
         }
         str1=str1+str2;
         if(str1.isEmpty()){
            return "0";
         }
         int i=0;
         int j=str1.length()-1;
         while(j>i&&(str1.charAt(i)=='0'||str1.charAt(j)=='0')){
            if(str1.charAt(i)=='0'){
                i++;
            }
            if(str1.charAt(j)=='0'){
                j--;
            }
         }
         if(i>j){
            return "0";
         }
         str1= str1.substring(i,j+1);
         if(str1.isEmpty()){
            return "0";
         }
         else{
            
            return str1;
         }
    }
}