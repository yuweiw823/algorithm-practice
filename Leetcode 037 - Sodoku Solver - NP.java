Leetcode 037 - Sodoku Solver - NP.java

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9) return;
        helper(board);
    }
    
    public boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(int k=1; k<=9; k++){
                        board[i][j] = (char)(k+'0');
                        boolean rowValid = isValidUnit(board, i, i, 0, 8);
                        boolean colValid = isValidUnit(board, 0, 8, j, j);
                        boolean unitValid = isValidUnit(board, i-i%3, i-i%3+2, j-j%3, j-j%3+2);
                        if(rowValid && colValid && unitValid && helper(board)){  //helper(board) 是之前的结果？
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    
    public boolean isValidUnit(char[][] board, int i1, int i2, int j1, int j2){
        boolean[] record = new boolean[9];
        for(int i=i1; i<=i2; i++){
            for(int j=j1; j<=j2; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(record[num-1]) return false;
                    else record[num-1] = true;
                }
            }
        }
        return true;
    }
}