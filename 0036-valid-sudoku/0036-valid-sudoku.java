class Solution {
    public boolean isValidSudoku(char[][] board) {
         for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(isValid(i,j,board)==false){
                    return false;
                }
            }
         }
         return true;
    }
    public static boolean isValid(int a,int b,char[][]board){
        for(int i=0;i<9;i++){
            if(board[i][b]!='.'&& board[i][b]==board[a][b]&& i!=a){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(board[a][j]!='.' && board[a][j]==board[a][b] && j!=b){
                return false;
            }
            
        }
        int row=a/3*3;
        int col=b/3*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]!='.'&& board[i][j]==board[a][b]&&a!=i&&b!=j){
                    return false;
                }
            }
        }
        return true;
        


    }
}