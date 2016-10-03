Leetcode 212 - Word Search II.java

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if(board == null || board.length == 0 || words == null || words.length == null) {
            return result;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                for(int k = 0; k < words.length; k++) {
                    if(words[k].charAt(0) == board[i][j]) {
                        boolean isFound = DFS(board, words[k], 0, i, j);
                        if(isFound) {
                            result.add(words[k]);
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
    
    public boolean DFS(char[][] board, String word，int k, int i, int j) {
        if(k == word.length()) {
            return true;
        }
        
        if(i < 0 || i >= board.legnth || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if(board[i][j] != word.charAt(k) {
            return false;
        }
        
        board[i][j] = '#';
        boolean result = DFS(board, word, k + 1, i + 1, j) 
                        || DFS(board, word, k + 1, i, j + 1) 
                        || DFS(board, word, k + 1, i - 1, j) 
                        || DFS(board, word, k + 1, i, j - 1);
                        
        board[i][j] = word.charAt(k);
        return result;
    }
}