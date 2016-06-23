Lintcode 074 - First Bad Version.java
http://www.lintcode.com/en/problem/first-bad-version/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
     //本题的重点在于，确保找到的bad version是第一个。第一个 fail 了，后面的都会 fail
     //this version and the following versions are all failed in the unit tests
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n <= 1) {
            return n;
        }
        
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                //bad 的区间一定在右边
                start = mid;
            }
        }
        return SVNRepo.isBadVersion(start) ? start : end;
    }
}
