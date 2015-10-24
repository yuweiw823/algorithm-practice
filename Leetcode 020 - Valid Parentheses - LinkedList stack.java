//Leetcode 020 - Valid Parentheses - LinkedList stack.java

//对于 stack 来说，top在最尾，add()和push()的功能相同；
// push(x): add an item on the top，从左边加上
// pop: remove the item at the top = remove(),都是从左边删除
// peek: return the item at the top (without removing it)
import java.util.*;

public class Solution {
    public static void main(String[] args){
        String s = "([]){}";
        boolean res = isValid(s);
        System.out.println(res + "");
    }
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')'); put('{', '}'); put('[', ']');
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stack.push(map.get(c));
            } else {
                if(stack.isEmpty() || (stack.peek() != c)) return false; //not match
                else stack.pop(); //match
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}