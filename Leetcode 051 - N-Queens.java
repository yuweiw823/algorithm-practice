//Leetcode 051 - N Queens.java
//典型的NP问题，NP Problem：对于一类问题，我们可能没有一个已知的快速的方法得到问题的答案，
//但是如果给我们一个candidate answer，我们能够在polynominal的时间内验证这个candidate answer到底是不是我们已知问题的答案
//http://www.cnblogs.com/Gavin_Liu/archive/2011/05/04/2012284.html

import java.util.*;

public class Solution {
  public static void main(String[] args){
        List<List<String>> results = new ArrayList<List<String>>();
        int[] res = new int[4];
        NQueen(4, 0, res, results);
    
        for(List<String> eachRes : results){
            for(String eachRow : eachRes){
                System.out.println(eachRow);
            }
            System.out.println("");
        }
    }

    public static void NQueen(int n, int currentRow, int[] res, List<List<String>> results){
        if(currentRow==n){
            //打印
            List<String> eachRes = new ArrayList<String>(); //each res
            for(int i=0;i<n; i++){  //each currentRow in each res
                StringBuffer eachRow = new StringBuffer();
                for(int j=0; j<n; j++){ //each res in each currentRow
                    if(res[i] == j) eachRow.append("Q");
                    else eachRow.append(".");
                }
                eachRes.add(eachRow.toString());
            }
            res.add(eachRes);
            return;
        }
        for(int i=0; i<n; i++){
            res[currentRow] = i;   //在每个row，试着把Q放到第i列
            if(checker(res, currentRow)){
                NQueen(n, currentRow + 1, res, results);
            }
        }
        
    }
  
    public static boolean checker(int[] res, int currentRow){
        for(int i=0; i<currentRow; i++){   //i<currentRow, 只需要检查已经放过的就可以
            if(res[currentRow] == res[i] || Math.abs(res[currentRow] - res[i]) == currentRow - i) return false;
        }
        return true;
    }
}
