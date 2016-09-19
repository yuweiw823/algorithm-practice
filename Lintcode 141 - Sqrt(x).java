class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if(x == 0) {
            return 0;
        }

        //防溢出，直接设置数据类型为long
        long start = 1; long end = x / 2;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            if(square <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }    
        
        if(start * start <= x) {
            return (int)start; //cast的方法，注意。
        } else {
            return (int)end;
        }
    }
}