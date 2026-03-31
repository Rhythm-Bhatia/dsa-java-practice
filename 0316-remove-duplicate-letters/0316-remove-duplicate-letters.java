class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character>stack=new Stack<>();
        Map<Character,Integer>map=new HashMap<>();
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))==1){
                continue;
            }
            
            while(!stack.isEmpty()&&s.charAt(i)<=stack.peek()){
                if(arr[stack.peek()-'a']>i){
                    map.put(stack.peek(),0);
                    stack.pop();
                    
                }
                else break;
            }
            
            stack.push(s.charAt(i));
            map.put(s.charAt(i),1);
            
            
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}