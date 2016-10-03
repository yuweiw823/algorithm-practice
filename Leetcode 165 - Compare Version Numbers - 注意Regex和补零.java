Leetcode 165 - Compare Version Numbers - 注意Regex和补零.java

public class Solution {
    public static void main(String[] args){
        int res = compareVersion("1.2.4", "0.3");
        System.out.println(res+ " ");
    }

    public static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null) return 0;
        if(version1 == null) return -1;
        if(version2 == null) return 1;
          
        // 这两句是多此一举，不需要  
        // version1 = version1+".";
        // version2 = version2+".";
        
        String[] v1 = version1.split("\\.");  //注意Regex表达式
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length); // 取最大长度
        
        for(int i=0; i<len; i++){
            int d1, d2;
            if(v1.length <= i) d1 = 0;  // 长度不够补零
            else d1 = Integer.parseInt(v1[i]);
            if(v2.length <= i) d2 = 0;
            else d2 = Integer.parseInt(v2[i]); 
            if(d1>d2) return 1;
            else if(d1<d2) return -1;
        }
        
        if(v1.length > len ) return 1;
        if(v2.length > len) return -1;
        
        return 0;
    }
}