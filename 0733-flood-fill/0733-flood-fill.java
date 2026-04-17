class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curcolor=image[sr][sc];
        dfs(sr,sc,image,color,curcolor);
        return image;
    }
    private void dfs(int i,int j,int[][]image,int color,int curcolor){
        if(i<0||j<0||i>=image.length||j>=image[0].length){
            return;
        }
        if(image[i][j]!=curcolor||image[i][j]==color){
            return;
        }
        image[i][j]=color;
        dfs(i,j+1,image,color,curcolor);
        dfs(i+1,j,image,color,curcolor);
        dfs(i,j-1,image,color,curcolor);
        dfs(i-1,j,image,color,curcolor);
        return;
    }
}