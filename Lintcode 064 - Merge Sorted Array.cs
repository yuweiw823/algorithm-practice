using System;
using System.Collections;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] A = new int[]{1,7,9,0,0};
            int[] B = new int[]{2,6};

            int[] result =  mergeArray(A, B, 3, 2);

            for(int i = 0; i < result.Length; i++)
            {   
                Console.Write(result[i] + ", ");
            }
        }

        static int[] mergeArray(int[] A, int[] B, int m, int n)
        {
            int pA = m - 1;
            int pB = n - 1;
            int i = A.Length - 1;

            while(pA >= 0 && pB >=0)
            {
                if(A[pA] > B[pB])
                {
                    A[i] = A[pA];
                    i--;
                    pA--;
                    Console.WriteLine(A[i]);
                }
                else
                {
                    A[i] = B[pB];
                    i--;
                    pB--;
                }
            }
            
            while(pB >=0)
            {
                A[i] = B[pB];
                i--;
                pB--;
            }

            while(pA >=0)
            {
                A[i] = A[pA];
                i--;
                pA--;
            }
        
            return A;
        }
    }

}
