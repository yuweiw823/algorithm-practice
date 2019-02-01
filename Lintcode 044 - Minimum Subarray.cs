using System;
using System.Collections;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] A = new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3};

            int result = MinSub(A);
            Console.WriteLine(result);

        }

        static int MinSub(int[] A){
            int max = int.MaxValue;
            int sum = 0;

            for(int i = 0; i < A.Length; i++)
            {
                sum += A[i];
                max = Math.Min(max, sum);
                sum = Math.Min(0, sum);
            }

            return max;
        }
    }
}
