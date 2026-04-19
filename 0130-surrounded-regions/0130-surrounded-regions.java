class Solution {
    public void solve(char[][] board) {
        
        boolean [][]visited=new boolean[board.length][board[0].length];
         for(int j=0;j<board[0].length;j++){
            if(visited[0][j]==false&&board[0][j]=='O'){
                dfs(board,0,j,visited);
            }
         }
         for(int i=0;i<board.length;i++){
            if(visited[i][board[0].length-1]==false&&board[i][board[0].length-1]=='O'){
                dfs(board,i,board[0].length-1,visited);
            }
         }
         for(int j=board[0].length-1;j>=0;j--){
            if(visited[board.length-1][j]==false&&board[board.length-1][j]=='O'){
                dfs(board,board.length-1,j,visited);
            }
         }
         for(int i=board.length-1;i>=0;i--){
            if(visited[i][0]==false&&board[i][0]=='O'){
                dfs(board,i,0,visited);
            }
         }
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='m'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
         }
         

    }
    private void dfs(char[][]board,int i,int j,boolean[][]visited){
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return;
        }
        if(visited[i][j]==true||board[i][j]=='X'){
            return;
        }
        visited[i][j]=true;
        board[i][j]='m';
        dfs(board,i,j+1,visited);
        dfs(board,i+1,j,visited);
        dfs(board,i,j-1,visited);
        dfs(board,i-1,j,visited);
        return;

    }
}