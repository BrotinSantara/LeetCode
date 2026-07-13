class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
    boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        //this is how we are replacing the r,c from arguments
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if we found an empty cell, we can break the outer loop as well
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft==true){
            return true;
        }
        //backtracking logic
        for(char num='1';num<='9';num++){
            if(isSafe(board,row,col,num)){
                board[row][col] = num;
                if(solve(board)){
                    //found the answer
                    return true;
                }
                    //backtrack
                    board[row][col] = '.'; 
                                 
            }
        }
        return false;
    }
 //   private static void display(int[][] board) {
   //     for(int[] row:board){
     //       for(int num:row){
       //         System.out.print(num+" ");
         //   }
          //  System.out.println();
        //}
    //}

    boolean isSafe(char[][] board, int row, int col, char num){
        // check for row
        for(int i=0;i<board.length;i++){
            //check if the number is already present in the row or not
            if(board[row][i]==num){
                return false;
            }
        }
        // check for column
        for(int i=0;i<board.length;i++){
            //check if the number is already present in the column or not
            if(board[i][col]==num){
                return false;
            }
        }
        // check for subgrid
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for(int r=rowStart;r<rowStart+sqrt;r++){
            for(int c=colStart;c<colStart+sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
