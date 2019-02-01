using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] nums = new int[]{3,2,5,4,7,8}; 
            int target = 9;

            int[] result = twoSum(nums, target);
            Console.WriteLine(result[0]);
            Console.WriteLine(result[1]);
        }

        static int[] twoSum(int[] nums, int target){
            int[] result = new int[2];
            Dictionary<int, int> hashMap = new Dictionary<int, int>();

            for(int i = 0; i < nums.Length; i ++)
            {
                if(hashMap.ContainsKey(target - nums[i]))
                {
                    result[0] = hashMap[target - nums[i]];
                    result[1] = i;
                }
                else
                {
                    hashMap[nums[i]] = i;
                }
            }

            return result;
        }
    }

}
