Lintcode 028 - Search a 2D Matrix.java

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        // write your code here
        int[] rowStart = new int[matrix.length];
        
        for (int i = 0; i < matrix.length - 1; i++) {
            rowStart[i] = matrix[i][0];
        }
        
        int targetRow = BinarySearch(rowStart, target);
        
        if (targetRow >= 0) {
            int targetCol = BinarySearch(matrix[targetRow], target);
            if (targetCol >= 0) {
                return matrix[targetRow][targetCol] == target ? true : false;
            }
        }
        
        return false;
        
    }
    
    private int BinarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        
        if (nums[end] <= target) {
            return end;
        } else if (nums[start] <= target) {
            return start;
        }
        
        return -1;
    }
}
