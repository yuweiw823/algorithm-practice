//Leetcode 077 - Combinations - 递归经典算法，必背.java

import java.util.*;

public class Solution {
    public static void main(String args[]){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = combine(4, 2);
        System.out.println(res);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n<k || n<0) return res;
        List<Integer> item = new ArrayList<Integer>();
        helper(n, k, 1, item, res);
        return res;
    }
    
    public static void helper (int n, int k, int start, List<Integer> item, List<List<Integer>> res){
        if(item.size() == k){
            //在combine中，只有res被返回了，如果仅仅写res.add(item)，item随着combine的结束被销毁。
            //new 了一个 item后，item的owner是res
            res.add((new ArrayList<Integer>(item)));  
            return;
        }
        for(int i=start; i<=n; i++){
            item.add(i);
            helper(n, k, i+1, item, res);
            item.remove(item.size()-1);
        }
    } 
}

helper(4,2,1,[],{})
    i =   [1 ~ 4]
    helper(4,2,2,[1],{})
        i =   [2 ~ 4]
        helper(4,2,3,[1 ,2],{}) - item.size()==2，先 res.add 再 item.remove(2)， 然后进入i=3
        helper(4,2,4,[1, 3],{})
        helper(4,2,5,[1, 4],{})
    item.remove(index1)    
    helper(4,2,3,[2],{})
        i =   [3 ~ 4]
        helper(4,2,4,[2, 3],{})
        helper(4,2,5,[2, 4],{})
    item.remove(index2)  
    helper(4,2,4,[3],{})
        i =    4
        helper(4,2,5,[3, 4],{}) - return
    item.remove(index3)      
    helper(4,2,5,[4],{})
        i == start == 5 不会进入这个循环