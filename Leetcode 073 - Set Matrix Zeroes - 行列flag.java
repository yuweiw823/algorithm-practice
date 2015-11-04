//Leetcode 073 - Set Matrix Zeroes.java

public class Solution {
    public static void main(String args[]){
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(matrix);
      
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }

    //正确的解法：
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowflag = false;  //第一行是否有0的flag
        boolean colflag = false;  //第一列是否有0的flag
        
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                colflag = true;
            }
        }
        for(int j=0; j<n; j++){
            if(matrix[0][j] == 0){
                rowflag = true;
            }
        }
        //第0行、第0列作为flag
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //再扫一遍matrix，检查每一格对应的0行0列的值
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //最后，变化0行0列
        if(colflag){
            for(int i=0; i<m;i++){
                matrix[i][0] = 0;
            }
        }
        if(rowflag){
            for(int j=0; j<n;j++){
                matrix[0][j] = 0;
            }
        }
    }
}