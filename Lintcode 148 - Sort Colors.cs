using System;
// using System.Collections;
// using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] nums = new int[]{2,1,0,2,1,1,0,1};
            int[] result = sortArray(nums);
            foreach(int i in result)
            {
                Console.WriteLine(i);
            }
        }

        static int[] sortArray(int[] nums)
        {
            int curr = 0;
            int left = 0;
            int right = nums.Length - 1;
            while(curr <= right)
            {
                if(nums[curr] == 0)
                {
                    swap(nums, curr, left);
                    curr++;
                    left++;
                }
                else if(nums[curr] == 1)
                {
                    curr++;
                }
                else
                {
                    swap(nums, curr, right);
                    right--;
                }
            }

            return nums;
        }

        static void swap(int[] nums, int i, int j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
