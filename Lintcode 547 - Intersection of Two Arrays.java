Lintcode 547 - Intersection of Two Arrays.java


//Method 1: Hashset
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return null;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        
        HashSet<Integer> resultSet = new HashSet<Integer>();
        for(int j = 0; j < nums2.length; j++) {
            if(set.contains(nums2[j]) && !resultSet.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        
        int size = resultSet.size();
        int[] result = new int[size];
        int index = 0;
        for(Integer num : resultSet) {
            result[index++] = num;
        }
        
        return result;
    }
}

//Method 2: sort & merge
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums2 == null) {
            return null;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int index = 0;
        int[] temp = new int[nums1.length];
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                if(index == 0 || temp[index-1] != nums1[i]) {  //不加入重复数字的重点
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] result = new int[index];
        for(int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }
}

//Method 3: sort & Binary Search

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] temp = new int[nums1.length];
        int index = 0;
        for(int i = 0; i < nums1.length; i++) {
            if(index == 0 || temp[index - 1] != nums1[i]) {
                boolean ifHasDup = BinarySearch(nums2, nums1[i]);
                if(ifHasDup) {
                    temp[index++] = nums1[i];
                }
            }
        }
        
        int[] result = new int[index];
        for(int j = 0; j < index; j++) {
            result[j] = temp[j];
        }
         
        return result;
    }
    
    public boolean BinarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(nums[start] == target || nums[end] == target) {
            return true;
        }
        
        return false;
        
    }
}