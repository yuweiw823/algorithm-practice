//LeetCode 167 - Two Sum - Sorted - Bisearch, 2pointer.java

class Solution {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 26;
        int [] result = twoSum(input, target);
        System.out.println(result[0] + " " + result[1]);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int [] res = {0, 0};

        for(int i=0; i<nums.length; i++){
            int j = BiSearch(nums, i, nums.length-1, target - nums[i]);
            if(j != -1){
                res[0] = i + 1;
                res[1] = j + 1;
                
            }
        }
        return res;
    }
    
    public static int BiSearch(int[] A, int start, int end, int key){
        int L = start;
        int R = end;
        
        while(L<R){
            int M = L + (R-L)/2;
            if(A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }
}



public class Solution {
    public static void main(String[] args){
        int[] nums = {2,3,4};
        int target = 6;
        int[] res = new int[2];
        res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }  
  
    public static int[] twoSum(int[] nums, int target) {
        int[] res = {0, 0};
        int L = 0, R = nums.length-1;
        Arrays.sort(nums);
        while(L < R){
            int numL = nums[L], numR = nums[R];
            int sum = numL + numR;  //int sum, 减少计算
            if(sum == target){
                res[0] = L+1;
                res[1] = R+1;
            }
            if(sum <= target){  //注意这里有个等于号
                while(numL == nums[L] && L < R){
                    L++;
                }
            }
            if (sum >= target){
                while(numR == nums[R] && L < R){
                    R--;
                }
            }
        }
        return res;
    }
}
