using System;

namespace algorithm_practice_CSharp
{
class BinarySearchSolution
{
    static void main()
    {
        int [] nums = new int[] {1,2,3,4,5,6,7};
        int target = 5;
        int result = BinarySearch(nums, target);
        Console.WriteLine(result);
    }

    static int BinarySearch(int[] nums, int target)
    {
        if(nums == null || nums.Length == 0)
        {
            return -1;
        }

        int start = 0;
        int end = nums.Length - 1;
        while(start + 1 < end)
        {
            int mid = start + (end - start) /2;
            if(target == nums[mid])
            {
                return mid;
            }
            else if(target > nums[mid])
            {
                start = mid;
            }
            else{
                end = mid;
            }
        }

        if(target == nums[start])
        {
            return start;
        }
        else if (target == nums[end])
        {
            return end;
        }
        return -1;
    }
}
}