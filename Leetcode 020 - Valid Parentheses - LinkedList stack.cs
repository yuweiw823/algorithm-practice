using System;
using System.Collections;
using System.Collections.Generic;

namespace CSharp
{
    class Program{
        static void Main()
        {
            String s = "([]){}";
            bool res = isValidParenthesis(s);
            Console.WriteLine(res);
        }

        static bool isValidParenthesis(string str)
        {
            Dictionary<char, char> parens = new Dictionary<char, char>();
            parens['('] = ')';
            parens['{'] = '}';
            parens['['] = ']';

            Stack stack = new Stack();
            int i = 0;
            while(i < str.Length)
            {
                if(parens.ContainsKey(str[i]))
                {
                    stack.Push(parens[str[i]]);
                }
                else
                {
                    if(stack.Count!= 0 || !stack.Peek().Equals(str[i]))
                    {
                        return false;
                    } else {
                        stack.Pop();
                    }
                }
            }

            return stack.Count!= 0;
        }
    }
}
