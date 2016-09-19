Lintcode 142 - O(1) Check Power of 2.java

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if(n <= 0) {
            return false;
        }
        //(power of 2) 的特点：  1000000....
        //(power of 2) - 1的特点：111111
        //100000 & 11111 == 0
        return (n & (n - 1)) == 0;  
    }
};