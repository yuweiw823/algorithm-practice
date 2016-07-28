Lintcode 004 - Ugly Number 2.java

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */

    //Q中的所有数值，都分别乘以2，3，5，之前未出现过的加入Q中
    public int nthUglyNumber(int n) {
        // Write your code here
        if(n <= 1) {
            return 1;
        }
        
        HashSet<Long> set = new HashSet<Long>(); //记录已经出现过的数
        Queue<Long> Q = new PriorityQueue<Long>();  //PriorityQueue会自动对内部的元素排序
        int[] factors = new int[3];  //2，3，5三个乘数因子
        factors[0] = 2;
        factors[1] = 3;
        factors[2] = 5;
        Q.add(Long.valueOf(1));
        set.add(Long.valueOf(1));

        long curr = 1;
        for(int j = 0; j < n; j++) { //
            curr = Q.poll();  //poll操作会弹出Q中的元素
            for(int i = 0; i < 3; i++) {
                long next = curr * factors[i]; //算出来的next可能会超过Integer的范围
                if(!set.contains(next)) {
                    Q.add(next);
                    set.add(next);
                }
            }
        }
        
        return (int)curr;
    }
};
