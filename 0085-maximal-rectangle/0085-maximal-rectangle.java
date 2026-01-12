
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int arr[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }
                else arr[j]=arr[j]+1;
            }
            //call and compare max
            maxArea=Math.max(maxArea,largestRectangle(arr));
        }
        return maxArea;
    }
    private int largestRectangle(int arr[]){
        Stack<Integer>stack=new Stack<>();
        int arr1[]=new int[arr.length];
        int arr2[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())arr1[i]=-1;
            else arr1[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())arr2[i]=arr.length;
            else arr2[i]=stack.peek();
            stack.push(i);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int width=arr2[i]-arr1[i]-1;
            int area=arr[i]*width;
            ans=Math.max(ans,area);
        }
        return ans;
    }
}