Leetcode 150 - Evaluate Reverse Polish Notation - 注意负数的判断.java

public class Solution {
    public static void main(String[] args){
        String[] tokens = {"4", "13", "5", "/", "+"};
        int res = evalRPN(tokens);
        System.out.println(res);
//         System.out.println(isInt("4"));
    }
    
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for(int i=0; i<tokens.length; i++){
            if(isInt(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int res = operate(tokens[i], a, b);
                stack.push(res);
            }
        }
        return stack.peek();
    }
    
    //注意负数的判断, s.charAt(0) == '-' && s.length() > 1
    public static boolean isInt(String s){
        if(s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <=9) return true;
        if(s.charAt(0) == '-' && s.length() > 1){
            if(s.charAt(1) - '0' >= 0 && s.charAt(1) - '0' <=9) return true;
        } 
        return false;
    }
    
    public static int operate(String s, int a, int b){
        int res = 0;
        switch(s){
            case "+" : res =  a + b; break;
            case "-" : res =  a - b; break;        
            case "*" : res =  a * b; break;
            case "/" : res =  a / b; break;
        }
        return res;
    }
}