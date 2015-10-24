// Leetcode 071 - Simplify Path - 使用stack.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        String path1 = "/home/";
        System.out.println(simplifyPath(path1));
        String path2 = "/a/./b/../../c/";
        System.out.println(simplifyPath(path2));
        String path3 = "/../";
        System.out.println(simplifyPath(path3));
        String path4 = "/home//foo/";
        System.out.println(simplifyPath(path4));
    }
  
    public static String simplifyPath(String path) {
        //维护一个栈，对于每一个块（以‘/’作为分界）进行分析，
        //遇到‘../’则表示要上一层，那么就是进行出栈操作，
        //遇到‘./’则是停留当前，直接跳过，其他文件路径则直接进栈即可。
        //String 比较使用 .equals()
        StringBuffer res = new StringBuffer();
        LinkedList<String> stack = new LinkedList<String>();
        String[] paths = path.split("/");
      
        for(String s: paths){
            if(s.equals("..") && stack.size()!=0) {  //注意 stack.size()!=0
                stack.pop();
            } else if(!s.equals("..") && !s.equals(".") && s !=null && !s.equals("")){
                stack.push(s);
            } 
        }
      
        for(int i=stack.size()-1; i>=0; i--){
            res.append("/");
            res.append(stack.get(i));
            
        }
          
        if(res.length() == 0) res.append("/");      //最后检查
        
        return res.toString();
    }
}