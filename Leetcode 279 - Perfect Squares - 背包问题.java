//直接抄了答案，自己再好好想一想

public class Solution {
    public int numSquares(int n) {
        int[] s = new int[n+1];
    
        for(int i = 1;i <= n; i++){
            s[i] = i;
            int sqrt = (int) Math.sqrt(i);
            
            if(i == sqrt*sqrt){
                s[i] = 1;
                continue;
            }
            
            for(int j = 1; j<=sqrt; j++){
                s[i] = Math.min(s[i], s[i-j*j] + 1);
            }
        }
        return s[n];
    }
}