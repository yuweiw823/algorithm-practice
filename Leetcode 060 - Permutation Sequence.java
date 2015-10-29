//Leetcode 060 - Permutation Sequence.java

public class Solution {
    public String getPermutation(int n, int k) {
        if(n <=0 || n > 9) return "";
        if(n == 1) return "1";
        k--;
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        for(int i=1; i<=n; i++){
            nums.add(i);
        }
        
        int round = n-1;
        int factor = factorial(n-1);
        while(round > 0){
            int index = k/factor;
            res.append(nums.get(index));
            nums.remove(index);    //注意：arraylist remove 后，所有后面的index都会自动-1，使index永远保持连续性
            
            k %= factor;
            factor /= round;
            round --;
        }
        res.append(nums.get(0));
        return res.toString();
    }
    
    
    public int factorial (int n){
        if(n==0 || n==1) return 1;
        for(int i=n-1; i>1; i--){
            n *= i;
        }
        return n;
    }
}