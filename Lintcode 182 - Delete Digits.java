Lintcode 182 - Delete Digits.java

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A == null || A.length() == 0) {
            return "";
        }
        
        // String 的顺序不能打乱。
        // 每次都删从左到右的第一个peak
        StringBuffer sb = new StringBuffer(A);
        int i, j;
        for(i = 0; i < k; i++) { //控制删除次数
            for(j = 0; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j++) {
                //循环到peak停止；
            }
            sb.delete(j, j + 1); //左开右闭，删除index为j的数。
        }
        
        //注意处理0
        int index = 0;
        while(index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        
        return sb.substring(index, sb.length()).toString();
    }
}