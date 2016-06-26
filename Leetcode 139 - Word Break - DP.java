Leetcode 139 - Word Break - DP.java
//这种单序列题，标记每个空隙，建立f[n+1]，答案在f[n]处
//       l   i   n   t   c   o   d   e
//     ^   ^   ^   ^   ^   ^   ^   ^   ^
//f   [0] [1] [2] [3] [4] [5] [6] [7] [8]

//基本算法：这个方法已经能够跑过93%的test case，但最后一个极端test case不过
public class Solution {    
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0){
            return true;
        }
        
        int n = s.length();
        boolean f[] = new boolean[n + 1];
        f[0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                f[i] = f[i] || f[j] && dict.contains(word);
            }
        }
        return f[n];
    }
}
    
//更进一步：增加提前结束循环的方法
public class Solution { 
    public int getMaxLen (Set<String> dict){
        int maxLen = 0;
        for (String word : dict) {
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int maxLen = getMaxLen(dict);
        if (maxLen == 0) {
            return false;
        }
        
        int n = s.length();
        boolean[] f = new boolean[n+1];
        f[0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(i - j <= maxLen) { //截取的字符串的长度小于dict中最长字符的长度
                    String word = s.substring(j, i);
                    if (f[j] && dict.contains(word)) {
                        f[i] = true;
                        break;
                    };
                }
            }
        }
        return f[n];
    }
}

//九章提供的算法：
public class Solution {
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
}