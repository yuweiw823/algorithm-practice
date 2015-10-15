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
            if(!isValid(board, i, i, 0, 8)) return false;//注意起止顺序，想不出的话就拿逼写一下
            if(!isValid(board, 0, 8, i, i)) return false;
        }
        for(int i=0; i<9; i+=3){  //Step是3的时候的写法
            for(int j=0; j<9; j+=3){
                if(!isValid(board, i, i+2, j, j+2)) return false;  //注意这里是+2;
            }
        }
        return true;
    }
  
    
    //使用Set判断
    public static boolean isValid(char[][] board, int i1, int i2, int j1, int j2){
        Set<Integer> singleSet = new HashSet();  //Set是Abstract的，需要initial具体的HashSet()

        for(int i=i1; i<=i2; i++){
            for(int j=j1; j<=j2; j++){

                if(board[i][j] != '.'){
                    int k = board[i][j]-'0';
                    if(singleSet.contains(k)) return false;  //Set.contains()
                    else singleSet.add(k); //Set.add()
                }
            }
        }
        return true;
    }
}