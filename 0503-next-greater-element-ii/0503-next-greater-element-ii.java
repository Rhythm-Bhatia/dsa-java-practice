

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result[]=new int[nums.length];
        int n=nums.length;
        Stack<Integer>stack=new Stack<>();
        Arrays.fill(result,-1);
        for(int i=2*n-1;i>=0;i--){
            int current=nums[i%n];
            while(!stack.isEmpty()&&stack.peek()<=current){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                result[i%n]=stack.peek();
                }
            }
            
            
            stack.push(current);
        }
        return result;
    }
}