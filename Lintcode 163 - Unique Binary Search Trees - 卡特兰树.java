Lintcode 163 - Unique Binary Search Trees - 卡特兰树.java


public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        //卡塔兰数
        //取一个结点作为root，所有可能性 = 左边的结点数 * 右边的结点数
        //count[3] = count[0] * count[2] + count[1] * count[1] + count[2] * count[0];

        int count[] = new int[n + 2];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        
        return count[n];
    }
}