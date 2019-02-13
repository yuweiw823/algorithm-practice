using System;
using System.Collections.Generic;

namespace CSharp
{
    class Program
    {
        static int count = 0;
        static void Main(string[] args)
        {
            int n = 4;

            List<List<int>> results = new List<List<int>>();
            int[] res = new int[n];

            NQueens(n, 0, results, res);

            foreach(List<int> item in results)
            {
                for(int i = 0; i < n; i++)
                {
                    for(int j = 0; j < n; j++)
                    {
                        if(item[i] == j)
                        {
                            System.Console.Write("Q ");
                        }
                        else
                        {
                            System.Console.Write(". ");
                        }
                    }
                    System.Console.WriteLine(" ");
                }
                System.Console.WriteLine("---------------");
            }
            System.Console.WriteLine("Count: " + count);
        }

        static void NQueens(int n, int currentRow, List<List<int>> results, int[] res)
        {
            if(currentRow >= n)
            {
                results.Add(new List<int>(res));
                count++;
                return;
            }

            for(int pos = 0; pos < n; pos++)
            {
                res[currentRow] = pos;
                if(isValidPosition(currentRow, res))
                {
                    NQueens(n, currentRow + 1, results, res);
                }
            }
        }

        static bool isValidPosition(int currentRow, int[] res)
        {
            for(int pos = 0; pos < currentRow; pos++)
            {
                if(res[currentRow] == res[pos] || Math.Abs(res[currentRow] - res[pos]) == currentRow - pos)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
