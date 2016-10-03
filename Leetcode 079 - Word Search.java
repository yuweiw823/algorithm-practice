Leetcode 079 - Word Search.java

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        
        if(word == null || word.length() == 0) {
            return true;
        }
        
        boolean result = false;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                   result = DFS(board, word, 0, i, j); 
                   if(result) { //可能会从board不同的position开始，但一旦有true，立即返回true
                       return result;
                   }
                }
            }
        }
        return result;
    }
    
    public boolean DFS(char[][] board, String word, int k, int i, int j) {
        if(k == word.length()) {
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        
        if(board[i][j] != word.charAt(k)) {
            return false;
        }

        board[i][j] = '#';
        
        boolean result = DFS(board, word, k + 1, i + 1, j) 
                || DFS(board, word, k + 1, i - 1, j)
                || DFS(board, word, k + 1, i, j + 1)
                || DFS(board, word, k + 1, i, j - 1);
                
        board[i][j] = word.charAt(k); //恢复board中原来的char，下一次寻找可能还要用
        return result;
        
    }
}