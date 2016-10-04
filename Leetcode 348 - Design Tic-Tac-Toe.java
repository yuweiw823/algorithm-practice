Leetcode 348 - Design Tic-Tac-Toe.java

public class TicTacToe {
    int size;
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.size = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        
        rows[row] += add;
        cols[col] += add;
        
        if(row == col) {
           diagonal += add;
        }
        
        if(row + col == size - 1) {
            antiDiagonal += add;
        }
        
        if(Math.abs(rows[row]) == size
            ||Math.abs(cols[col]) == size
            ||Math.abs(diagonal) == size
            ||Math.abs(antiDiagonal) == size)
        {
            return player;
        }
            
        return 0;
    }
}