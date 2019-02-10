using System;
using System.Collections;

namespace CSharp
{

    class Program{
        static void Main()
        {
            int[] A = new int[] {2,3,1,1,4};
            int[] B = new int[] {3,2,1,0,4};

            bool result1 = JumpGame(A);
            bool result2 = JumpGame(B);

            Console.WriteLine(result1);
            Console.WriteLine(result2);

        }

        static bool JumpGame(int[] A)
        {
            if(A == null || A.Length == 0)
            {
                return false;
            }
            //Keep an int to recoard the farest index can move to
            int size = A.Length;
            int farest = A[0];
            
            for(int i = 1; i < size; i++)
            {
                if(farest >= i) 
                {
                    farest = Math.Max(farest, i + A[i]);
                    if(farest >= size - 1)
                    {
                        return true;
                    }
                }
            }

            return (farest >= size - 1);
        }
    }

}
