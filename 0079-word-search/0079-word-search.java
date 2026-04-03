class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][]=new boolean[board.length][board[0].length];
        boolean ans=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    ans=solve(i,j,0,board,word,visited);
                    if(ans==true){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
    private boolean solve(int i,int j,int k,char [][]board,String word,boolean[][]visited){
        if(j>=board[0].length||i>=board.length||i<0||j<0){
            return false;
        }
        if(visited[i][j]==true){
            return false;
        }
        if(word.charAt(k)!=board[i][j]){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        boolean right=solve(i,j+1,k+1,board,word,visited);
        boolean down=solve(i+1,j,k+1,board,word,visited);
        boolean left=solve(i,j-1,k+1,board,word,visited);
        boolean up=solve(i-1,j,k+1,board,word,visited);
        visited[i][j]=false;
        return right||down||left||up;

    }
}