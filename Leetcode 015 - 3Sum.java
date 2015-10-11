// Leetcode 015 - 3 Sum

class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, -5, 6};
        List<List<Integer>> res = new ArrayList();
        res = threeSum(nums);
        System.out.println(res);
    }
    //使用 3 个 pointer，第一个i控制循环，另两个在 i 后的区间内，一个从前往后，一个从后往前，夹逼。
    //有大量的重复， 通过 while (b == nums[L] && L < R) L++; 进行处理。
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        
        int i = 0;
        int last = nums.length-1;
        while(i < last) {
            int L = i + 1, R = last;
            int a = nums[i];
          
            while(L<R){
                int b = nums[L], c = nums[R];
                int sum = a + b + c;
              
                if (sum == 0) {
                    result.add(Arrays.asList(a, b, c));
                } 
                if (sum <= 0) {
                    while (b == nums[L] && L < R) L++;
                }
                if (sum >= 0) {
                    while (c == nums[R] && L < R) R--;
                }
            }
            while (a == nums[i] && i < last) i++;
        }
        return result;
    }
}