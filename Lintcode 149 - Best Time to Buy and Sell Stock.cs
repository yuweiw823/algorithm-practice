using System;
using System.Collections;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] A = new int[]{3,2,5,4,7,8};

            int result = maxProfit(A);
            Console.WriteLine(result);
        }

        static int maxProfit(int[] prices){
            int min = Int32.MaxValue; //成本
            int profit = 0; //利润

            for(int i = 0; i <prices.Length; i++)
            {
                min = Math.Min(min, prices[i]);
                profit = Math.Max(profit, prices[i] - min);
            }

            return profit;
        }
    }

}
