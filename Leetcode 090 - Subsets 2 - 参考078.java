import java.util.*;
//每次在原先的结果集上加入新元素，和078的方法一样，但由于有重复元素，所以在什么时候加重复元素，需要一些判断
//遇到重复元素时，只把当前结果集的(后半部分，即上一步中加入这个元素的所有子集)加上当前元素，加入到结果集中
import java.util.*;

public class Solution {
    public static void main(String[] args){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] nums = {1,1,2};
        res = subsetsWithDup(nums);
        System.out.println(res);
        
    }
  
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length ==0) return res;
      
        ArrayList<Integer> lastSize = new ArrayList<Integer>();  
        lastSize.add(0); //使用List来储存lastSize，如果用 Integer 容易跳出作用域
      
        helper(nums, nums.length-1, res, lastSize);
      
        return res;
    }
    
    public static void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> lastSize){
        if(index == -1){
            res.add(new ArrayList<Integer>());
            return;
        }
        helper(nums,index-1, res, lastSize);
        int size = res.size();
        int start = 0;
        if(index > 0 && nums[index] == nums[index-1]){
            start = lastSize.get(0);
        }
        for(int i=start;i<size;i++){
            List<Integer> item = new ArrayList<Integer>(res.get(i));
            item.add(nums[index]);
            res.add(item);
        }
        lastSize.set(0, size);
    }
}

helper(nums, 2, [[], [1], [1，1], [2], [1,2], [1,1,2]], 6)
    helper(nums, 1, [[], [1], [1,1]], 3)
        helper(nums, 0, [[], [1]], 1)
            helper(nums, -1, [[]], )
            return;
        index = 0;
        item: []->[1]; lastSize == 1; start == 0;
    index == 1;
    item: [1]->[1,1]; lastSize == 2; start == 1;
index == 2
item: []->[2], [1]->[1,2], [1,2]->[1,2,2]; lastSize == 3; start == 0;

[]                      - index == -1 时，res.add后
[] | [1]                - index ==  0 时，res.add后
[] | [1]*| [1,1]        - index ==  1 时，res.add后，*仅仅加了这个结果
[] | [1] | [1,1] | [2],[1,2],[1,1,2] - index == 2 时，res.add后



