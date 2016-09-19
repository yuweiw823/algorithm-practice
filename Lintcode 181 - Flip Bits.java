Lintcode 181 - Flip Bits.java

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        //在第一步 c = a ^ b 的时候已经一次性异或完毕。c右移直至等于0。每一位是1则 + 1
        for(int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1;
        }
        return count;
    }
};
