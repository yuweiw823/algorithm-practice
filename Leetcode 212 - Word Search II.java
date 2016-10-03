Leetcode 212 - Word Search II.java

//使用Trie解，但是一直调试不过

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        
        if(board == null || board.length == 0 || words == null ||words.length == 0) {
            return result;
        }
        
        Trie trie = new Trie();
        trie.buildTrie(words);
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                DFS(board, i, j, "", trie, result);
            }
        }
        
        return new ArrayList<String>(result);
    }
    
    
    public void DFS (char[][] board, int i, int j, String str, Trie trie, List<String> result) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        if(board[i][j] == '#') {
            return;
        }
        
        str = str + board[i][j];
        
        if(!trie.prefix(str)) {
            return;
        }
        
        if(trie.search(str)) {
            result.add(str);
        }
        
        char tmp = board[i][j];
        board[i][j] = '#';
        
        DFS(board, i + 1, j, str, trie, result);
        DFS(board, i, j + 1, str, trie, result);
        DFS(board, i - 1, j, str, trie, result);
        DFS(board, i, j - 1, str, trie, result);
        board[i][j] = tmp;
    }
}

class Trie{
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void buildTrie(String[] words) {
        for(String word : words) {
            this.root.insert(word, 0);
        }
    }
    
    public boolean search(String word) {
        char[] wordChar = word.toCharArray();
        TrieNode node = this.root.find(wordChar, 0);
        if(node != null && node.item.equals(word)) {
            return true;
        }
        return false;
    }
    
    public boolean prefix(String word) {
        char[] wordChar = word.toCharArray();
        TrieNode node = this.root.find(wordChar, 0);
        if(node != null) {
            return true;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] children;
    String item;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.item = "";
    }
    
    public void insert(String word, int index) {
        if(index == word.length()) {
            this.item = word;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
        if (this.children[pos] == null) {
            this.children[pos] = new TrieNode();
        }
        insert(word, index + 1);
    }
    
    public TrieNode find(char[] word, int index) {
        if (index == word.length) {
            return this;
        }
        
        int pos = word[index] - 'a';
        if(this.children[pos] == null) {
            return null;
        }
        
        return find(word, index + 1);
    }
}




//从word search 1 里衍生出来的方法。但是DFS容易stackoverflow，所以改用Trie来做
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
    
    public boolean DFS(char[][] board, String word, int k, int i, int j) {
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