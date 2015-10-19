//Leetcode 052 - N Queens2.java


import java.util.*;

public class Solution {
	public static void main(String[] args){
		int res = totalNQueens(4);
		System.out.println(res);
	}

    public static int totalNQueens(int n) {
        int[] col = new int[n];
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(n, 0, col, res);
        return res.get(0);
    }
    
    public static void helper(int n, int row, int[] col, List<Integer>res){
    	//关于这里为什么一定要用一个Arraylist来储存结果。如果用int，则传递进来的仅仅是引用而不是本身，无法记录；

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
        for(int i=0; i<row; i++){
            if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) return false;
        }
        return true;
    }
}