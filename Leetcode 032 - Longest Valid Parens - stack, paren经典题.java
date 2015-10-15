//Leetcode 032 - Longest Valid Parentheses - stack, trick.java

import java.util.*;

  
public class Solution {
    public static void main(String[] args){
        String s = "()(()";
        int res = longestValidParentheses(s);
        System.out.println(res + "");
    }
  
    //well-form 的定义：自身是well-form,同时内含的所有括号也是 well-form
    public static int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = -1;
        int maxLen = 0;
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){                     //遇到'('并记录位置
                stack.push(i);  
            } else {                        //遇到')''
                if(stack.isEmpty()) start = i;  //栈为空，最开始的状况,或之前的括号全部完整,但一下子遇到了一个')'，前功尽弃
                else {                          //栈不为空，里面有'('，但不清楚有几个，等待更多地')'凑成完整的一对。
                    stack.pop();                    //推出对应这个'('的')'
                    if(stack.isEmpty()) maxLen = Math.max(maxLen, i-start); //栈为空，之前的括号全部完整
                    else maxLen = Math.max(maxLen, i-stack.peek());         //栈不为空，还需要更多的')'来凑
                }
            }
        }
        return maxLen;
    }


    //这种方法有缺陷，"()(()" 为例。长度应是 2，但这种算法返回的是 4
    //所以必须用位置来记录，而不仅仅是count成对的括号数量。
    public static int longestValidParentheses_original(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        int count = 0;
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(')');
            } else {
                if(!stack.isEmpty() && stack.peek() == ')' ){
                    
                    stack.pop();
                    count+=2;
                }
            }
        }
        return count;
    }
}

