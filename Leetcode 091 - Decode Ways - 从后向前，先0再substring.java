
//单序列动态规划
//注意遇到“0”的处理方法
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] f = new int[s.length() + 1];
        
        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;  
        
        for(int i = 2; i < f.length; i++) {
            String part1 = s.substring(i - 1, i);
            if(!part1.equals("0")) {
                f[i] = f[i - 1]; 
            }
            
            String part2 = s.substring(i - 2, i);
            int digit = (part2.charAt(0) - '0') * 10 + part2.charAt(1) - '0';
            
            if(digit >= 10 && digit <= 26) {
                f[i] = f[i] + f[i - 2];
            }
        }
        
        return f[f.length - 1];
    }
}
