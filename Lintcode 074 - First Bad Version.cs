using System;

// To execute C#, please define "static void Main" on a class
// named Solution.

class Solution
{
    static void Main()
    {
        bool [] versions = new bool [] {false, false, false, false, true, true, true, true, true, true};
        int result = findBadVersion(versions);
        Console.WriteLine(result);      
    }
    
    static int findBadVersion(bool [] nums)
    {

        int n = nums.Length;
        
        if (n <= 1) {
            return 1;
        }
        
        int start = 0;
        int end = n - 1;
        
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            
            if(!nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return (nums[start] ? start: end) + 1;
    }
}