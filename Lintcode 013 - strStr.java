Lintcode - 013. strStr.java

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        
        int i, j;
        //注意，source的循环只到source.length() - target.length() + 1
        for(i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if(source.charAt(i + j) != target.charAt(j)){
                    break;
                    //break，跳出整个 for j 循环
                    //continue，继续下一个 ++ 循环
                }
            }
            //注意这个 if j 判断放在for j 结束后
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
 
