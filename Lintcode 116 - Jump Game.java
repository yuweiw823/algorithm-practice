Lintcode 116 - Jump Game.java
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
This problem have two method which is Greedy and Dynamic Programming.
The time complexity of Greedy method is O(n).
The time complexity of Dynamic Programming method is O(n^2).
We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
Example
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
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
    
}

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
                if(fastest >= len - 1) {
                    return true; //这一句可以不用加，但加了后一旦跳到最后格，可以提前结束
                }
            } else {
                return false;
            }
        } 
        
        return fastest >= (len - 1);
    }
