Lintcode 034 - N-Queens 2.java

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int sum; 
    public int totalNQueens(int n) {
        //write your code here
        int[] col = new int[n];
        sum = 0;
        dfs(col, 0, n); //注意，传参不需要传sum，否则会出错
        return sum;
    }
    
    private void dfs(int[] col, int row, int n) {
        if(row == n) {
            sum++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            col[row] = i;
            if(isValid(col, row)) {
                dfs(col, row + 1, n);
            } 
        }
    }
    
    public boolean isValid(int[] col, int row) {
        for(int i=0; i<row; i++){
            if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) {
                return false;
            }
        }
        return true;
        
    }
};

