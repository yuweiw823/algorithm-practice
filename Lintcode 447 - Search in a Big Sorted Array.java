//http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        //log(k) 给了提示。正常二分法的array长度为n，则log(n)
        //这里先要找到大致的长度
        int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;
        }
        //at this time, index could be out of range.
        //但不用考虑溢出，因为自动返回 Integer.MAX，
        //可看作在index位置有个比target大的数，程序仍然能继续运行

        int start = 0, end = index;        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid; //一旦array有重复元素，就上这一句
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
    }
}