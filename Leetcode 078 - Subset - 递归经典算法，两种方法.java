Leetcode 078 - Subset.java

import java.util.*;
//每个元素都有选与不选两个选择，C++本的解法
public class Solution {
    public static void main(String args[]){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] nums = {1,2,3};
        res = subsets(nums);
        System.out.println(res);
      
    }
    //对于每一种元素，都有两个选择：选或不选
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length ==0) return res;
        List<Integer> item = new ArrayList<Integer>();
        helper(nums, 0, item, res);
        return res;
    }
    
    public static void helper(int[] nums, int step, List<Integer>item, List<List<Integer>>res){
        if(step == nums.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        //不选这个元素
        helper(nums, step+1, item, res);
        //选这个元素
        item.add(nums[step]);
        helper(nums, step+1, item, res);
        item.remove(item.size()-1); //一直在使用同一个item生成结果，所以要记得remove
    }
}

helper(nums, 0, [], [[]])
    不 helper(nums, 1, [], [[]]);
        不 helper(nums, 2, [], [[]])
            不 helper(nums, 3, [], [[]]) - step==3，add
            选 helper(nums, 3, [3],[[]]) - step==3，add
            remove 3

        选 helper(nums, 2, [2], [[]])
            不 helper(nums, 3, [2], [[]]) - step==3，add
            选 helper(nums, 3, [2, 3],[[]]) - step==3，add
            remove 3
        remove 2

    选 helper(nums, 1, [1], [[]]);
        不 helper(nums, 2, [1], [[]])
            不 helper(nums, 3, [1], [[]]) - step==3，add
            选 helper(nums, 3, [1, 3],[[]]) - step==3，add
            remove 3

        选 helper(nums, 2, [1, 2], [[]])
            不 helper(nums, 3, [1, 2], [[]]) - step==3，add
            选 helper(nums, 3, [1, 2, 3],[[]]) - step==3，add
            remove 3
        remove 2
    remove1



正确结果：[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
如果不remove：[[], [3], [3, 2], [3, 2, 3], [3, 2, 3, 1], [3, 2, 3, 1, 3], [3, 2, 3, 1, 3, 2], [3, 2, 3, 1, 3, 2, 3]]


import java.util.*;
//每次在原先的结果集上加入新元素，java http://blog.csdn.net/linhuanmars/article/details/24286377 的解法
public class Solution {
    public static void main(String[] args){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] nums = {1,2,3};
        res = subsets(nums);
        System.out.println(res);
        
    }
  
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length ==0) return res;
        List<Integer> item = new ArrayList<Integer>();
        helper(nums, nums.length-1, res);
        return res;
        
    }
    
    public static void helper(int[] nums, int index, List<List<Integer>> res){
        if(index == -1){
            res.add(new ArrayList<Integer>()); //在最递归的里层加入一个空ArrayList，最初的item
            return;
        }
        helper(nums,index-1, res);
        int size = res.size();
        for(int i=0;i<size;i++){
            List<Integer> item = new ArrayList<Integer>(res.get(i));
            item.add(nums[index]);
            res.add(item);
        }
    }
}

helper(nums, 2, [], [[], [1], [2], [1,2], ])
    helper(nums, 1, [], [[], [1], [2], [1,2]])
        helper(nums, 0, [1], [[], [1]])
            helper(nums, -1, [], [[]])
            return;
        index = 0;
        item: []->[1];
    index == 1;
    item: []->[2], [1]->[1,2]; 
index == 2
item: []->[3], [1]->[1,3], [2]->[2,3], [1,2]->[1,2,3]

[]                      - index == -1 时，res.add后
[] | [1]                - index ==  0 时，res.add后
[],  [1] | [2],[1,2]    - index ==  1 时，res.add后
[],  [1],  [2],[1,2] | [3],[1,3],[2,3],[1,2,3] - index == 2 时，res.add后




