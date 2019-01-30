using System;

// To execute C#, please define "static void Main" on a class
// named Solution.

class Solution
{
    static void Main()
    {
        int [] nums = new int [] {1,2,2,2,2,2};
        int target = 2;
        int result = find(nums, target);
        Console.WriteLine(result);
        
    }
    
    static int find(int [] nums, int target)
    {
        if (nums == null || nums.Length == 0)
        {
            return -1;
        }
        
        int start = 0;
        int end = nums.Length - 1;
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
            {
                end = mid;
            }
            else if(nums[mid] < target)
            {
                start = mid;
            }
            else {
                end = mid;
            }
            
        }
        
        if(nums[start] == target)
        {
            return start;
        }
        else if(nums[end] == target)
        {
            return end;
        }

        return -1;
    }
}
