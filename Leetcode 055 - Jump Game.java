//Leetcode 055 - Jump Game.java
//Leetcode 045 - Jump Game2.java

Jump Game I - 返回boolean，能否到达最后端
public class Solution {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums) + "");
    }

方法1：贪心法，从左向右扫，和 LeetCode 134 类似
时间复杂度O(n)
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0) {
            return true;
        }
        int fastest = A[0];
        int len = A.length;
        
        for(int i = 1; i < len; i++){
            if(fastest >= i) {  //can reach i
                fastest = Math.max(fastest, i + A[i]);
                if(fastest >= len - 1) { //这个 if 可以不用加，但加了后一旦跳到最后格，可以提前结束
                    return true; 
                }
            } else {
                return false;
            }
        } 
        return fastest >= (len - 1);
    }
}

方法2：动态规划
时间复杂度O(n^2),仅仅是用于说明这种题可以使用动态规划解，正常还应使用贪心法解
    public boolean canJump(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return false;
        }
        
        int len = A.length;
        boolean[] canjump = new boolean[len];
        canjump[0] = true;
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++) {
                //index j is reachable itself, and can reach i from j
                if(canjump[j] && j + A[j] >= i) {
                    canjump[i] = true;
                    break;  //一定要加 break
                }
            }
        }
        return canjump[len - 1];
    }  


Jump Game II - 返回最小步数
方法1: 动态规划
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[] minSteps = new int[len];
        minSteps[0] = 0;
        
        for(int i = 1; i < len; i++){
            minSteps[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                //index j is reachable itself, and can reach i from j
                if(minSteps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    minSteps[i] = minSteps[j] + 1;
                    break;  //一定要加 break
                }
            }
        }
        return minSteps[len - 1];
    }

方法2：贪心法，仅做参考，懒得花时间研究
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }


