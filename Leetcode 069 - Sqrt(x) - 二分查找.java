//Leetcode 069 - Sqrt(x) - 二分查找.java

public class Solution {
    public static void main(String[] args){
        System.out.println(mySqrt(400000000));
    }
  
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;

        int L = 1;
        int R = x/2;        //注意R的起始位置

        while(L < R){
           int M = (R+L)/2;
            if(x/M >= M) {  //注意判断条件，以及不能写成 M*M <= x，否则会溢出
                L = M+1;
            } else{            
                R = M-1;
            }
        }
        return (L > x/L) ? L-1 : L; //注意返回条件，以及不能写成 L*L > x，否则会溢出
    }
}