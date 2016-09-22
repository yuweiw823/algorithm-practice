Lintcode 092 - Backpack.java

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(A == null || A.length == 0 || m == 0) {
            return 0;
        }
        
        boolean[][] f = new boolean[A.length + 1][m + 1];
        
        f[0][0] = true;
        
        for(int i = 0; i < A.length; i++) { //items
            for(int j = 0; j <= m; j++) { //capacity
                f[i + 1][j] = f[i][j];
                if(j - A[i] >= 0 && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
                //公式：f[i + 1][j] = f[i][j] || f[i][j - A[i]];
            }
        }
        
        // for(int i = 0; i <= A.length; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         String val = f[i][j] ? "T " : "  ";
        //         //System.out.print(val);
        //     }
        //     //System.out.println("");
        // }
        
        //int j = m;
        for(int j = m; j >= 0; j--) {
            if(f[A.length][j]) {
                return j;
            }
        }
        
        return 0;
    }
}