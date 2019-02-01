using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] nums = new int[3]{1,3,4};
            List<List<int>> result = new List<List<int>>{};   
            List<int> list = new List<int>{};

            Subset(nums, result, list, 0);

            foreach(var clist in result)
            {
                foreach(var num in clist)
                {
                    Console.Write(num + ", ");
                }
                Console.WriteLine(" ");
            }
        }

        static void Subset(int[] nums, List<List<int>> result, List<int> list, int pos)
        {

            result.Add(new List<int>(list));
            for(int i = pos; i< nums.Length; i++)
            {
                list.Add(nums[i]);
                Subset(nums, result, list, i + 1);
                list.Remove(list[list.Count - 1]);
            }
        }
    }
}
