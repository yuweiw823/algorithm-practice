using System;

// To execute C#, please define "static void Main" on a class
// named Solution.

class Solution
{
    static void Main()
    {
        int [] nums = new int [] {1,3,5,6};
        int target = 7;
        int result = findPosition(nums, target);
        
        Console.WriteLine(result);      
    }
    
    static int findPosition(int [] nums, int target)
    {
        if (nums == null || nums.Length == 0)
        {
            return 0;
        }
        
        
        int start = 0;
        int end = nums.Length - 1;
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if(target <= nums[start])
        {
            return start;
        } else if (target <= nums[end])
        {
            return end;
        } else
        {
            return end + 1;
        }
    }   
}