//Leetcode 006 - ZigZag Conversion.java
//学到的重要用法：横排转竖排。

public class Solution {
    public static void main (String[] args){
        String result = new String();
        result = convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
  
    public static String convert(String s, int numRows) {
        //有多少numRow就创建一个几项的array
        StringBuffer[] res_array = new StringBuffer[numRows]; //注意这里使用方括号
        for(int i=0; i<numRows; i++){  //然后在这里初始化每个 StringBuffer
            res_array[i] = new StringBuffer();
        }
        
        int p = 0;
        while(p < s.length()){
            //正序填充每个StringBuffer的第1列，第3列，第5列
            for(int x=0; x<numRows && p<s.length() ; x++){
                res_array[x].append(s.charAt(p++));  //StringBuffer 使用 append
            }//逆序填充每个StringBuffer的第2列，第4列，第6列
            for(int y=numRows-2; y>0 && p<s.length(); y--){
                res_array[y].append(s.charAt(p++));
            }
        }
        StringBuffer res = new StringBuffer();
        for(int i=0; i<numRows; i++){
            res.append(res_array[i]);
        }
        return res.toString();
    }
}