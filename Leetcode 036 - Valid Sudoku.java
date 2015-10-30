//Leetcode 036 - Valid Sudoku.java

import java.util.*;

public class Solution {
    public static void main(String[] agrs){
        String[] input = {".87654321","2........","3........",
                        "4........","5........","6........",
                        "7........","8........","9........"};
      
        char[][] board = new char[9][9];
      
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = input[i].charAt(j);
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
      
        boolean res = isValidSudoku(board);
        System.out.println(res + "");
    }
    
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            if(!isValid(board, i, i, 0, 8)) return false;//注意起止顺序，想不出的话就拿笔写一下
            if(!isValid(board, 0, 8, i, i)) return false;
        }
        for(int i=0; i<9; i+=3){  //Step是3的时候的写法
            for(int j=0; j<9; j+=3){
                if(!isValid(board, i, i+2, j, j+2)) return false;  //注意这里是+2;
            }
        }
        return true;
    }
    
    //使用boolean[]判断
    public static boolean isValidUnit(char[][] board, int i1, int i2, int j1, int j2){
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