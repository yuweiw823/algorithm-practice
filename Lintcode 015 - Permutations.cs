using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] nums = new int[4]{1,2,3,4};
            List<List<int>> result = new List<List<int>>{};   
            List<int> list = new List<int>{};

            Permutations(nums, result, list);

            foreach(var clist in result)
            {
                foreach(var num in clist)
                {
                    Console.Write(num + ", ");
                }
                Console.WriteLine(" ");
            }
        }

        static void Permutations(int[] nums, List<List<int>> result, List<int> list)
        {
            if(list.Count == nums.Length)
            {
                result.Add(new List<int>(list));
                return;
            }

            for(int i = 0; i< nums.Length; i++)
            {
                if(!list.Contains(nums[i]))
                {
                    list.Add(nums[i]);
                    Permutations(nums, result, list);
                    list.Remove(list[list.Count - 1]);
                }
            }
        }
    }
}
