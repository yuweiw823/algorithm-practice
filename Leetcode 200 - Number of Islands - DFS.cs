using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{

        static int count = 0;
        static void Main()
        {
            int[,] grid = new int[5,5]{
                {1, 1, 1, 0, 0}, 
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
            };

            for(int i = 0; i < grid.GetLength(0); i++)
            {
                for(int j = 0; j < grid.GetLength(1); j++)
                {
                    if(grid[i,j] == 1)
                    {
                        dfs(grid, i, j);
                        count++;
                    }

                }
            }
            Console.WriteLine(count);
        }

        static void dfs (int[,] grid, int i, int j)
        {
            if(i < 0 || i >= grid.GetLength(0) || j < 0 || j >= grid.GetLength(1))
            {
                return;
            }

            if(grid[i,j] != 1)
            {
                return;
            }

            grid[i,j] = -1;

            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }
}
