//Leetcode 051 - N Queens.java
//典型的NP问题，NP Problem：对于一类问题，我们可能没有一个已知的快速的方法得到问题的答案，
//但是如果给我们一个candidate answer，我们能够在polynominal的时间内验证这个candidate answer到底是不是我们已知问题的答案
//http://www.cnblogs.com/Gavin_Liu/archive/2011/05/04/2012284.html

import java.util.*;

public class Solution {
  public static void main(String[] args){
        List<List<String>> res = new ArrayList<List<String>>();
        int[] col = new int[4];
        NQueen(4, 0, col, res);
    
        for(List<String> eachRes : res){
            for(String eachRow : eachRes){
                System.out.println(eachRow);
            }
            System.out.println("");
        }
    }

    public static void NQueen(int n, int row, int[] col, List<List<String>> res){
        if(row==n){
            List<String> eachRes = new ArrayList<String>(); //each res
            for(int i=0;i<n; i++){  //each row in each res
                StringBuffer eachRow = new StringBuffer();
                for(int j=0; j<n; j++){ //each col in each row
                    if(col[i] == j) eachRow.append("Q");
                    else eachRow.append(".");
                }
                eachRes.add(eachRow.toString());
            }
            res.add(eachRes);
            return;
        }
        for(int i=0; i<n; i++){
            col[row] = i;   //在每个row，试着把Q放到第i列
            if(checker(col, row)){
                NQueen(n, row+1, col, res);
            }
        }
        
    }
  
    public static boolean checker(int[] col, int row){
        for(int i=0; i<row; i++){   //i<row, 只需要检查已经放过的就可以
            if(col[row] == col[i] || Math.abs(col[row] - col[i]) == row - i) return false;
        }
        return true;
    }
}
