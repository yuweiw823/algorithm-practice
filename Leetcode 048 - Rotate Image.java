//Leetcode 048 - Rotate Image.java
//旋转一切矩阵的方法：

public class Solution {
    public static void main(String [] args){
      
        int[][] matrix = {{1,2}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = rotate(matrix);
      
        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                System.out.print(res[i][j]);
            }
            System.out.println("");
        }
    }
  
	//注意：逆时针旋转，i j 互换，所以i的关系从j找，j的东西从i找   
    public static int[][] rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] res = new int [cols][rows];
        for(int j=0; j<cols; j++){
            for(int i=0; i<rows; i++){
                res[j][i] = matrix[rows-i-1][j]; 
            }
        }
        
        return res;
        
    }
}

//方法1: 题目是return void，且矩阵是正方形, 用一个空[][]作temp
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] res = new int [cols][rows];
        for(int j=0; j<cols; j++){
            for(int i=0; i<rows; i++){
                res[j][i] = matrix[rows-i-1][j]; 
            }
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }

//方法2: 在本身的矩阵中完成
//左上片和右上片交换（不包括对角线），再上半片和下半片交换
//或者 左下片和右上片交换；再左半片和右半片交换，也可以得到同样的效果
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int j=0; j<n; j++){
            for(int i=0; i+j<n; i++){ //左上片和右上片交换（不包括对角线）
                
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
                
            }
        }
        
        for(int i=0; i<n/2; i++){ //上半片和下半片交换
            for(int j=0; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        
    }
    







