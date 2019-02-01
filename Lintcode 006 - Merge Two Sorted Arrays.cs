using System;
using System.Collections;

namespace CSharp
{
    class Program{
        static void Main()
        {
            int[] result =  mergeArray();
            for(int i = 0; i < result.Length; i++)
            {   
                Console.Write(result[i] + ", ");
            }
        }

        static int[] mergeArray()
        {
            int[] A = new int[]{1,3,5,7};
            int[] B = new int[]{2,4,6,8};

            if ((A == null || A.Length == 0) && (B == null || B.Length == 0))
            {
                return new int[0];
            }

            if(A == null || A.Length == 0)
            {
                return B;
            }

            if(B == null || B.Length == 0)
            {
                return A;
            }

            int[] result = new int[A.Length + B.Length];

            int i = 0;
            int j = 0;

            while(i < A.Length && j < B.Length)
            {
                if(A[i] <= B[j])
                {
                    result[i + j] = A[i];
                    i++;
                }
                else 
                {
                    result[i + j] = B[j];
                    j++;
                }
            }

            while(i < A.Length)
            {
                result[i + j] = A[i];
                i++;
            }

            while(j < B.Length)
            {
                result[i + j] = B[j];
                j++;
            }

            return result;
        }
    }

}
