//LeetCode 16 - 3Sum Closet


class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, -5, 6, 4, 7};
        int res = threeSumClosest(nums, 1);
        System.out.println(res);
    }
    //Leetcode 15 相同的方法
    //使用 3 个 pointer，第一个i控制循环，另两个在 i 后的区间内，一个从前往后，一个从后往前，夹逼。
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int i=0; 
        int last = nums.length-1;
        int result = nums[i]+nums[i+1]+nums[last];
        while (i < last){
            int j=i+1, k=last;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target ) j++;
                else k--;
                
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
            i++;
        }
        return result;
    }
}

class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, -5, 6, 4, 7};
        int res = threeSumClosest(nums, 1);
        System.out.println(res);
    }
    
    //还是同样地方法，但for循环更清晰
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0; i<nums.length-1; i++){
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target ) j++;
                else k--;
                
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}