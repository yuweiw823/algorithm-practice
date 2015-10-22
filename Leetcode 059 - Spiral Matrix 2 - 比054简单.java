//Leetcode 059 - Spiral Matrix 2 - 比054简单.java

public class Solution {
    public static void main(String[] args){
        int n = 3;
        int[][] res = generateMatrix(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(res[i][j] + ", ");
            }
            System.out.println("");
        }
        
    }
  
    public static int[][] generateMatrix(int n) {
        int borderMax = n/2;
        int[][] res = new int[n][n];
        
        //b is border
        int d = 1;
        for(int b=0; b<borderMax; b++){
            for(int i=b, j=b; j<n-1-b; j++){
                res[i][j] = d;
                d++;
            }
            
            for(int i=b, j=n-1-b; i<n-1-b; i++){
                res[i][j] = d;
                d++;
            }
            
            for(int i=n-1-b, j=n-1-b; j>b; j--){
                res[i][j] = d;
                d++;
            }
            
            for(int i=n-1-b, j=b; i>b; i--){
                res[i][j] = d;
                d++;
            }
        }
        
        if(n%2==1){
            res[borderMax][borderMax] = d;
        }
        
        return res;
    }
}