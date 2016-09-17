class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        //
        if(x == 0) {
            return 0;
        }
        
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
            return (int)start;
        } else {
            return (int)end;
        }
    }
}