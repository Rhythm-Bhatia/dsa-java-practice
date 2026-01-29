class Solution {
    public int sumSubarrayMins(int[] arr) {
        int prevmin[]=new int[arr.length];
        int nextmin[]=new int[arr.length];
        Stack<Integer>stack=new Stack<>();
        prevmin[0]=-1;
        stack.push(0);
        
        for(int i=1;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevmin[i]=-1;
            }
            else prevmin[i]=stack.peek();
            stack.push(i);

        }
        stack.clear();
        stack.push(arr.length - 1);
        nextmin[arr.length-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextmin[i]=arr.length;
            }
            else nextmin[i]=stack.peek();
            stack.push(i);

        }
        long sum=0;
        for(int i=0;i<arr.length;i++){
            long leftsum=i-prevmin[i];
            long rightsum=nextmin[i]-i;
            long contribution=((long)arr[i]*leftsum*rightsum);
            sum=sum+contribution;
        }
        long ans=sum%(1000000000+7);
        return (int)ans;
    }
}