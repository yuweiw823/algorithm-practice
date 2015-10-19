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
