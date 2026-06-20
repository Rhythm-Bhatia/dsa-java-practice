class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        if(m==1){
            int max=0;
            int index=0;
            for(int i=0;i<n;i++){
                if(mat[i][0]>=max){
                    max=mat[i][0];
                    index=i;
                }
            }
            return new int[]{index,0};
        }
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int max=0;
            int ii=0;
            int jj=mid;
            for(int i=0;i<n;i++){
                if(mat[i][mid]>max){
                    max=mat[i][mid];
                    ii=i;
                    jj=mid;
                }
            }
            if(checkleft(mat,ii,jj)&&checkright(mat,ii,jj)){
                return new int[]{ii,jj};
            }
            else if(checkleft(mat,ii,jj)==false){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    private boolean checkleft(int[][]mat,int ii,int jj){
        if(jj==0)return true;
        else {
            if(mat[ii][jj-1]<mat[ii][jj]){
                return true;
            }
            else{
                return false;
            }
        }
    }
    private boolean checkright(int[][]mat,int ii,int jj){
        if(jj==mat[0].length-1)return true;
        else {
            if(mat[ii][jj+1]<mat[ii][jj]){
                return true;
            }
            else{
                return false;
            }
        }
    }
}