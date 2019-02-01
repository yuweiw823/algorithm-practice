using System;
using System.Collections;

namespace CSharp
{

    class Program{
        static void Main()
        {
            int n = 6;
            int result = ClimbingStairs(n);
            Console.WriteLine(result);
        }

        static int ClimbingStairs(int n)
        {
            if(n == 0)
            {
                return 0;
            }

            if(n == 1)
            {
                return 1;
            }

            int sum = 0;
            int last = 1;
            int last2 = 1;

            for(int i = 2; i < n; i++)
            {
                sum = last + last2;
                last = sum;
                last2 = last;
            }

            return sum;

        }
    }

}
