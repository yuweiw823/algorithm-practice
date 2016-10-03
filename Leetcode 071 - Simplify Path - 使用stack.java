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
  
        //维护一个栈，对于每一个块（以‘/’作为分界）进行分析，
        //遇到‘../’则表示要上一层，那么就是进行出栈操作，
        //遇到‘./’则是停留当前，直接跳过，其他文件路径则直接进栈即可。
        //String 比较使用 .equals()
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "";
        }
        
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        StringBuffer result = new StringBuffer();
        
        for(int i = 0; i < paths.length; i++) {
            String curr = paths[i];
            if(curr.equals(".")) {
                continue;
            }
            
            if(curr.equals("..") && stack.size() != 0) {
                stack.pop();
                continue;
            }
            
            if(curr != null && curr.length() != 0 && !curr.equals("") && !curr.equals("..")) {
                stack.push(curr);
            }
        }
        
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            result.append("/").append(stack.get(i));
        }
        
        if(result.length() == 0) {
            result.append("/");
        }
        
        return result.toString();
    }
}