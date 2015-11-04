//Leetcode 074 - Search a 2D Matrix - 插入二分搜索.java
//注意 target > 整个数组中最大数字的情况

public class Solution {
    public static void main(String args[]){
        int[][] matrix1 = {{1,3,5,7},{10,12,16,20},{23,30,34,50},{51,54,57,59}};
        int[][] matrix2 = {{1}};
        
        System.out.println(searchMatrix(matrix2, 12));
        System.out.println(searchMatrix(matrix2, 2));
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] cols = new int[matrix.length];
        
        //搜索最后一列
        for (int i=0; i<matrix.length; i++){
            cols[i] = matrix[i][n-1];
        }
        
        int row = BiSearch(0, m-1, cols, target);
        //当 target > 整个matrix最后一个数字时，row（插入位置）会溢出，return false
        if(row >= m) return false;
        int col = BiSearch(0, n-1, matrix[row], target);
        
        return matrix[row][col] == target;                     
    }
    
    //使用返回插入位置的二分法 
    public static int BiSearch(int start, int end, int[] A, int key){
        int L = start;
        int R = end;
        while(L<R){
            int M = (L+R)/2;
            if(A[M] < key){
                L = M+1;
            } else {
                R = M;
            }
        }
        return (A[L] < key) ? L+1 : L;
    }
}