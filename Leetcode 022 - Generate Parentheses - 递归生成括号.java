//Leetcode 022 - Generate Parentheses - Recursive.java

import java.util.*;

//L代表还剩下的(的数量，R同理； 左括号数量一定永远 <= 右括号，因为先放。
//如果出现了 R < L 的情况，必定是先放了一个右括号，立刻 return 

public class Solution {
    public static void main(String[] agrs){
        List<String> res = new ArrayList<String>();
        res = generateParenthesis(3);
        System.out.println(res);
    }  
  
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        helper(n, n, new String(), res);   //new String() 记得加上括号
        return res;
    }
    
    public static void helper (int L, int R, String item, ArrayList<String> res){
        if(R<L) return;   //先看 return 条件
        if(L==0 && R==0) res.add(item);   //再 add to res 条件
        if(L > 0) helper(L-1, R, item+"(", res);
        if(R > 0) helper(L, R-1, item+")", res);
    }
}

(3, 3, "", res)
	(2, 3, (, res)
		(1, 3, ((, res)
			(0, 3, (((, res)
				(0, 2, (((), res)
					(0, 1, ((()), res)
						(0, 0, ((())), res) -------- add to res
			(1, 2, ((), res)
				(0, 2, (()(, res)
					(0, 1, (()(), res)
						(0, 0, (()()), res) -------- add to res
				(1, 1, (()), res)
					(0, 1, (())(, res)
						(0, 0, (())(), res) -------- add to res
					(1, 0)					-------- r < l return 

		(2, 2, (), res)
			(1, 2, ()(, res)
				(0, 2, ()((, res)
					(0, 1, ()((), res)
						(0, 0, ()(()), res) -------- add to res
				(1, 1, ()(), res)
					(0, 1, ()()(, res)
						(0, 0, ()()(), res) -------- add to res
					(1, 0)					-------- r < l return
			(2, 1)							-------- r < l return	
	(3, 2) 									-------- r < l return