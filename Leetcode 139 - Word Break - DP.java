Leetcode 139 - Word Break - DP.java


http://blog.csdn.net/linhuanmars/article/details/22358863
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length()==0) return false;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<=i; j++){
                String str = s.substring(j, i+1);
                if(res[j] && wordDict.contains(str)){
                    res[i+1] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}

res[i+1] 表示前i个字符能否由dict中的字串组成