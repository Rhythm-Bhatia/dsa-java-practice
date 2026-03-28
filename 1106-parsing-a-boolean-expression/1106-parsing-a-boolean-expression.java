class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character>stack=new Stack<>();
        if(expression.length()==1){
            if(expression.charAt(0)=='f'){
                return false;
            }
            else return true;
        }
        for(int j=0;j<expression.length();j++){
            stack.push(expression.charAt(j));
            if(expression.charAt(j)==')'){
                StringBuilder sb=new StringBuilder();
                while(stack.peek()!='&'&&stack.peek()!='|'&&stack.peek()!='!'){
                    sb.append(stack.pop());
                }
                sb.append(stack.pop());
                sb.reverse();
                if(sb.charAt(0)=='|'){
                    for(int i=0;i<sb.length();i++){
                        if(sb.charAt(i)=='t'){
                            stack.push('t');
                            break;
                        }
                    }
                    if(stack.isEmpty()||stack.peek()!='t'){
                        stack.push('f');
                    }
                }
                else if(sb.charAt(0)=='&'){
                    for(int i=0;i<sb.length();i++){
                        if(sb.charAt(i)=='f'){
                            stack.push('f');
                            break;
                        }
                    }
                    if(stack.isEmpty()||stack.peek()!='f'){
                        stack.push('t');
                    }

                }
                else{
                    if(sb.charAt(2)=='f')stack.push('t');
                    else{
                        stack.push('f');
                    }
                }
            }
        }
        if(stack.pop()=='t'){
            return true;
        }
        return false;
    }
}