//Leetcode 052 - N Queens2.java


import java.util.*;

public class Solution {
	public static void main(String[] args){
		int res = totalNQueens(4);
		System.out.println(res);
	}

    public static int totalNQueens(int n) {
        //第几个col，皇后放在了哪个row里
        //e.g [0,1,2]
        // # 0 0
        // 0 # 0
        // 0 0 #


        int[] col = new int[n];
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(n, 0, col, res);
        return res.get(0);
    }
    
    public static void helper(int n, int row, int[] col, List<Integer>res){
        if(n==row){
            res.set(0, res.get(0)+1);
            return;
        }
        
        for(int i=0; i<n; i++){
            col[row] = i;
            if(checker(col, row)){
                helper(n, row+1, col, res);
            }
        }
    }
    
    public static boolean checker(int[] col,int row){
        for(int i=0; i < row; i++){
            if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) return false;
        }
        return true;
    }
}