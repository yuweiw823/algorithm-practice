public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        

        //注意，for 循环在最外层，注意查重
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            int sum;
            while(start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(new ArrayList(list));
                    
                    start++;
                    end--;

                    //这里需要使用 while 循环查重
                    while(start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while(start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}