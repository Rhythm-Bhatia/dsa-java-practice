class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int high=n*m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/m;
            int col=mid%m;
            if(target==matrix[row][col]){
                return true;
            }
            else if(matrix[row][col]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}