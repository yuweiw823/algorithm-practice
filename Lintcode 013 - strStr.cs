using System;
class Solution
{
    static void Main()
    {
        string source = "qwerty";
        string target = "rty";
        
        int result = strStr(source, target);
        Console.WriteLine(result + "");
    
    }
    
    static int strStr(string source, string target)
    {
        if(source == null || source.Length == 0) 
        {
            return -1;
        }
        
        int i;
        int j;
        for (i = 0; i < source.Length + target.Length - 1; i++) 
        {
            for (j = 0; j < target.Length; j++)
            {
                if (source[i + j] != target[j])
                {
                    break;
                }
            }
            
            if(j == target.Length)
            {
                return i;    
            }
        }              
        return -1;
    }
}
