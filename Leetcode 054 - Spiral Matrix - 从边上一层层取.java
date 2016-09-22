//Leetcode 054 - Spiral Matrix - 从边上一层层取.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> res = new ArrayList<Integer>();
        res = spiralOrder(matrix);
        System.out.println(res);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
          return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int minBorder = Math.min(m, n);
        int depth = minBorder / 2;
        

        for(int d = 0; d < depth; d++) {
            for(int i = d, j = d; j < n - 1 - d; j++) {
                result.add(matrix[i][j]);
            }
            
            for(int i = d, j = n - 1 - d; i < m - 1 - d; i++) {
                result.add(matrix[i][j]);
            }
            
            for(int i = m - 1 - d, j = n - 1 - d; j > d; j--) {
                result.add(matrix[i][j]);
            }
            
            for(int i = m - 1 - d, j = d; i > d; i--) {
                result.add(matrix[i][j]);
            }
        }  
        
        if(minBorder % 2 == 1) {
            if(m <= n) {
                for(int i = depth, j = depth; j < n - depth; j++) {
                    result.add(matrix[i][j]);
                }
            } else {
                for(int i = depth, j = depth; i < m - depth; i++) {
                    result.add(matrix[i][j]);
                }
            }
        } 
        return result;
    }
}