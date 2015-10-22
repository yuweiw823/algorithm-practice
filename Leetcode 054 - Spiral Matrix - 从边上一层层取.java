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
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return res;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min_di = Math.min(rows, cols);
        int borderMax = min_di/2;
        
        //b is border
        for(int b=0; b<borderMax; b++){
            for(int i=b, j=b; j<cols-1-b; j++){
                res.add(matrix[i][j]);
            }
            for(int i=b, j=cols-1-b; i<rows-1-b; i++){
                res.add(matrix[i][j]);
            }
            for(int i=rows-1-b, j=cols-1-b; j>b ; j--){
                res.add(matrix[i][j]);
            }
            for(int i=rows-1-b, j=b; i>b; i--){
                res.add(matrix[i][j]);
            }
        }
        
        if(min_di % 2 == 1){
            if(cols<rows){//竖着长
                for(int i=borderMax, j=borderMax; i<rows-borderMax; i++){
                    res.add(matrix[i][j]);
                }
            }else{
                for(int i=borderMax, j=borderMax; j<cols-borderMax; j++){
                    res.add(matrix[i][j]);
                }
            } 
        }
        
        return res;
    }
}