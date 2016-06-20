//Leetcode 074 - Search a 2D Matrix - 插入二分搜索.java
//注意 target > 整个数组中最大数字的情况

//http://www.lintcode.com/en/problem/search-a-2d-matrix/
//提取出BinarySearch的方法，构建每一行首位的数组
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

//直接两次 BinarySearch
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int targetRow = 0;
        //first search in row
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(matrix[start][0] == target || matrix[end][0] == target) {
            return true;
        }
        
        if (matrix[end][0] < target ) {
            targetRow = end;
        } else {
            targetRow = start;
        }
        
        start = 0; end = matrix[0].length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(matrix[targetRow][start] == target || matrix[targetRow][end] == target) {
            return true;
        }
        return false;
    }
}
