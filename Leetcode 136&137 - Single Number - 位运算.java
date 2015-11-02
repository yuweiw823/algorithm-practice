Leetcode 136&137 - Single Number.java

//方法1：HashMap，起始value均为2，遇到一次value--，value == 0时清除key，看最后剩下的

//方法2：位操作 - 适用于出现n次的情况
//其它元素都出现2次
public class Solution {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];

        for(int k=0; k<32; k++){
            for(int i=0;i<nums.length; i++){
                digit[k] += (nums[i]>>k) & 1;
            }
        }
        int res = 0;
        for(int k=0; k<32; k++){
            res += (digit[k] % 2) << k; //这里2取余
        }
        return res;
    }
}
//其它元素都出现3次
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] digit = new int[32];
        int res = 0;
        for(int i=0; i<nums.length; i++){
            for(int k=0; k<32; k++){
                digit[k] += (nums[i]>>k) & 1;
            }
        }
        for(int k=0; k<32; k++){
            res += (digit[k] % 3) << k;   //这里3取余
        }
        return res;
    }
}


//方法3：比较巧妙的方法，但仅限于出现两次的情况
使用异或操作。同一个数异或两次，得0。
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i]; 
        }
        return res;
    }
}