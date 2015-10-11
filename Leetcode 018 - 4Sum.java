//Leetcode 018 - 4Sum.java

class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, -5, 6, 4, 7};
        List<List<Integer>> res = new ArrayList();
        res = fourSum(nums, 12);
        System.out.println(res);
    }
    
    //与 3Sum 同样地方法，只是多嵌套一层循环
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        
        int i = 0, last = nums.length-1;
        while(i < last){
            int j = i+1; 
            int a = nums[i];
            while(j < last){
                int x = j + 1, y = last;
                int b = nums[j];
                while (x < y){
                    int c = nums[x], d = nums[y];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        result.add(Arrays.asList(a, b, c, d));
                    }
                    if (sum <= target) {
                        while(c==nums[x] && x < y){
                            x++; 
                        }
                    }
                    if (sum >=target) {
                        while(d==nums[y] && x < y){
                            y--;
                        }
                    }
                }
                while (b == nums[j] && j < last) j++;
            }
            while (a == nums[i] && i < last) i++;
        }
        return result;
    }
}