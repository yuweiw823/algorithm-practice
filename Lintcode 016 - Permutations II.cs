// Lintcode 016 - Permutations II
using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] nums = new int[4]{1,1,3,4};
            List<List<int>> result = new List<List<int>>{};   
            List<int> list = new List<int>{};
            bool[] used = new bool[4];

            Permutation2(nums, result, list, used);

            foreach(var clist in result)
            {
                foreach(var num in clist)
                {
                    Console.Write(num + ", ");
                }
                Console.WriteLine(" ");
            }
        }

        static void Permutation2(int[] nums, List<List<int>> result, List<int> list, bool[] used)
        {

            if(list.Count == nums.Length)
            {
                result.Add(new List<int>(list));
                return;
            }

            for(int i = 0; i< nums.Length; i++)
            {
                if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                {
                    continue;
                }

                if(used[i])
                {
                    continue;
                }

                used[i] = true;
                list.Add(nums[i]);
                Permutation2(nums, result, list, used);
                list.Remove(list[list.Count - 1]);
                used[i] = false;
            }
        }
    }
}
