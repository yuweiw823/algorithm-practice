Leetcode 165 - Compare Version Numbers - 注意Regex和补零.java

public class Solution {
    public int compareVersion(String version1, String version2) {
        if((version1 == null || version1.length() == 0) && (version2 == null || version2.length() == 0)) {
            return 0;
        }
        
        if(version1 == null || version1.length() == 0) {
            return 1;
        }
        
        if(version2 == null || version2.length() == 0) {
            return -1;
        }
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        
        for(int i = 0; i < len; i++) {
            int d1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
            int d2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);
            
            if(d1 > d2) {
                return 1;
            } else if(d1 < d2) {
                return -1;
            }
        }
        
        if(v1.length > len) {
            return 1;
        }
        if(v2.length > len) {
            return -1;
        }
        
        return 0;
    }
}