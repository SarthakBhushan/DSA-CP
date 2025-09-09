class Solution {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(dfs(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][]board, String word, int r, int c, int i){
        if(i==word.length())return true;
        if(r<0 || c<0 || r>=rows || c>=cols || board[r][c]!=word.charAt(i) || board[r][c]=='#'){
            return false;
        }
        board[r][c]='#';
        boolean res = dfs(board, word,r+1, c, i+1)||
                      dfs(board, word,r-1, c, i+1)||
                      dfs(board, word,r, c+1, i+1)||
                      dfs(board, word,r, c-1, i+1);
        board[r][c] = word.charAt(i);
        return res;
    }
    
}
