using System;

// To execute C#, please define "static void Main" on a class
// named Solution.

class Solution
{
    static void Main()
    {
        int [] nums = new int [] {4,5,6,7,1,2,3};
        int target = 7;
        int result = findPosition(nums);
        
        Console.WriteLine(result);      
    }
    
    static int findPosition(int [] nums)
    {
        if(nums == null || nums.Length == 0)
        {
            return -1;
        }

        int start = 0;
        int end = nums.Length - 1;
        
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end])
            {    
                end = mid;
                
            } else if (nums[mid] >= nums[end])
            {
                start = mid;
            }
            
        }
        
        return Math.Min(nums[start], nums[end]);
        
    }
    
    
}


