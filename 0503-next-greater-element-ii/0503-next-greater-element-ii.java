class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int num[]=new int[nums.length*2];
        for(int i=0;i<num.length;i++){
            num[i]=nums[i%nums.length];
        }
        Stack<Integer>stack=new Stack<>();
        //put in array when i<nums.length
        stack.push(num[num.length-1]);
        for(int i=num.length-2;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=num[i]){
                
                stack.pop();
            }
            if(i<nums.length){
                if(stack.isEmpty()){
                    nums[i]=-1;
                }
                else nums[i]=stack.peek();
            }
            stack.push(num[i]);


        }
        return nums;
    }
}