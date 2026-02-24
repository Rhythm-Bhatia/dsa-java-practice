class Solution {
    
    public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=0;k<grid[0].length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return pick(grid,0,0,grid[0].length-1,dp);
    }
    public int pick(int[][]grid,int i,int j1,int j2,int[][][]dp){
        if(j1>=grid[0].length||j2>=grid[0].length||j1<0||j2<0){
            return -1000000;
        }

        if(i==grid.length-1){
            if(j1==j2)return grid[i][j1];
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int max=-1000000;
        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                int n=0;
                if(j1==j2){
                    n= grid[i][j1]+pick(grid,i+1,j1+k,j2+l,dp);
                }
                else{
                    n= grid[i][j1]+grid[i][j2]+pick(grid,i+1,j1+k,j2+l,dp);
                }
                max= Math.max(max,n);

            }
        }
        return dp[i][j1][j2]=max;
    }
}