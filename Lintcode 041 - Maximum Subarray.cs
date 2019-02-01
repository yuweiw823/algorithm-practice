using System;
using System.Collections;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] A = new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3};

            int result = MaxiSub(A);
            Console.WriteLine(result);

        }

        static int MaxiSub(int[] A){
            int max = int.MinValue;
            int sum = 0;

            for(int i = 0; i < A.Length; i++)
            {
                sum += A[i];
                max = Math.Max(max, sum);
                sum = Math.Max(0, sum);
            }

            return max;
        }
    }

}
