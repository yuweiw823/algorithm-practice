Leetcode 365 - Water and Jug Problem.java

    //求x, y 的最大公约数，如果 z % 最大公约数 == 0，则返回true
    //greatest common divisor
    //http://www.acmerblog.com/pour-water-problem-5615.html
    //辗转相除法 http://www.guokr.com/post/569512/
问：120与42的最大公约数是多少？
辗转相除：
120/42=2...36，然后把除数放到被除数的位置上，余数放到除数的位置上，被除数和商扔掉没用
	^      ^
42 /36=1...6，
	^      ^
36 /6 =6...0，余数是0了，这时候除数6就是120与42的最大公约数
	^


public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z || y == z) {
            return true;
        }
        if(z == 0) {
            return true;
        }
        if(x == 0 || y == 0) {
            return false;
        }
        if(x + y < z) {
            return false;
        }
        
        int gcdNum = gcd(x, y);
        System.out.println(gcdNum);
        return z % gcdNum == 0; 
    }
    
    public int gcd(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        int r = 1;
        while(r > 0){
            r = m % n;
            if(r == 0) {
                return n;
            } else {
                m = n;
                n = r;
            }
        }
        return 1;
    }
}