class Solution {
    public int largestMagicSquare(int[][] grid) {
        int colSum[][]=new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0)colSum[i][j]=grid[i][j];
                else{
                    colSum[i][j]=grid[i][j]+colSum[i-1][j];
                }
            }
        }
        int rowSum[][]=new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(j==0)rowSum[i][j]=grid[i][j];
                else{
                    rowSum[i][j]=grid[i][j]+rowSum[i][j-1];
                }
            }
        }
        for(int side=Math.min(grid.length,grid[0].length);side>=2;side--){
            for(int i=0;i<grid.length-side+1;i++){
                for(int j=0;j<grid[0].length-side+1;j++){
                    int target=rowSum[i][side+j-1]-(j==0?0:rowSum[i][j-1]);
                    boolean flag=true;

                    for(int k=i;k<=i+side-1;k++){
                        int sum=rowSum[k][side+j-1]-(j==0?0:rowSum[k][j-1]);
                        if(sum!=target){
                            flag=false;
                            break;
                        }
                        
                    }
                    if(flag==false)continue;
                    for(int m=j;m<=j+side-1;m++){
                        int sum=colSum[side+i-1][m]-(i==0?0:colSum[i-1][m]);
                        if(sum!=target){
                            flag=false;
                            break;
                        }
                    }
                    if(flag==false)continue;
                    int diagonal=0;
                    int antidiagonal=0;
                    
                    for(int n=0;n<side;n++){
                        diagonal=diagonal+grid[i+n][j+n];
                        antidiagonal=antidiagonal+grid[i+n][j+side-1-n];
                        
                    }
                    if(diagonal==target&&antidiagonal==target){
                        return side;
                    }

                }
            }
        }
        return 1;
    }
}