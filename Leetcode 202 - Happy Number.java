Leetcode 202 - Happy Number.java

方法1：使用set
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)){
            set.add(n);
            if(n==1) return true;
            n = cal(n);
        }
        return false;
    }
    
    public int cal(int n){
        int s = 0;
        while(n>0){
            s+= (n%10)*(n%10);
            n /= 10;
        }
        return s;
    }
}

方法2：类似于 Linked List Cycle 的方法。
x走一步，y走两步，
x==1 或 y==1 return true;
x==y return false;

public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x > 1){
            x = cal(x);
            y = cal(cal(y));
            if(y == 1 || x == 1) return true;
            if(x == y) return false;
        }
        return true;
        
    }
    
    public int cal(int n){
        int s = 0;
        while(n>0){
            s+= (n%10)*(n%10);
            n /= 10;
        }
        return s;
    }
}