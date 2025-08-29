class Solution {
    public boolean isValid(String s) {
        if(s.length()==1)return false;
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
              else{
                if(stack.isEmpty()) return false; 
                char top=stack.pop();
                 if((top=='[' && c!=']')) {
                    return false;
                    }
                    if(top=='{' && c!='}') return false;
                    if(top=='(' && c!=')') return false;
               
              }
        }
        return stack.isEmpty();
    }
}