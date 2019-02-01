using System;
using System.Collections;

namespace CSharp
{

    class Program{
        static void Main()
        {
            int result = UniquePath(4,5);
            Console.Write(result);
        }

        static int UniquePath(int m, int n)
        {
            if(m == 0 || n == 0)
            {
                return 0;
            }

            int[,] record = new int[m, n];

            for(int i = 0; i < m; i++)
            {
                record[i,0] = 1;
            }

            for(int j = 0; j < n; j++)
            {
                record[0,j] = 1;
            }

            for(int i = 1; i < m; i++)
            {
                for(int j = 1; j < n; j++)
                {
                    record[i,j] = record[i, j-1] + record[i-1,j];
                }
            }

            return record[m-1,n-1];

        }
    }

}
