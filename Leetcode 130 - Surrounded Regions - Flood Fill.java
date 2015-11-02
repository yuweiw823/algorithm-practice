Leetcode 130 - Surrounded Regions - Flood Fill.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        char[][] board = {{'O','O'}, {'O','O'}};
        solve(board);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }    

    public static void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        // 把四周一圈的所有'O'标记成'#'，这些都是不符合条件的，最后会变会'O'
        for(int i=0; i< board.length; i++){
            fill(board, i, 0);   //检查所有第0列
            fill(board, i, board[0].length-1); //检查所有最后1列
        }
        for(int j=0; j<board[0].length; j++){
            fill(board, 0, j);   //检查所有第0行
            fill(board, board.length-1, j); //检查所有最后1列
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';   //不在同一片的'O'必然是被'X'包围
                else if(board[i][j] == '#') board[i][j] = 'O';  //恢复不符合条件的'O'
            }
        }
    }
    
    //把同一片的'O'变成'#',使用一个queue来做BFS
    public static void fill(char[][] board, int i, int j){
        if(board[i][j] != 'O') return;
        board[i][j] = '#';   //将所有'O'变成'#'；
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = i * board[0].length + j;   //相当于将格子一次编号，code就是号码。
        
        queue.offer(code);   //'#'放入一个queue
        
        while(!queue.isEmpty()){
            code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            //然后检查上下左右，开始flood fill
            if(row > 0 && board[row-1][col] == 'O'){
                queue.offer((row-1)*board[0].length + col);
                board[row-1][col] = '#';
            }
            if(row < board.length-1 && board[row+1][col] == 'O'){
                queue.offer((row+1)*board[0].length + col);
                board[row+1][col] = '#';
            }
            if(col > 0 && board[row][col-1] == 'O'){
                queue.offer((row)*board[0].length + col-1);
                board[row][col-1] = '#';
            }
            if(col < board[0].length-1 && board[row][col+1] == 'O'){
                queue.offer((row)*board[0].length + col+1);
                board[row][col+1] = '#';
            }            
        }
    }
}