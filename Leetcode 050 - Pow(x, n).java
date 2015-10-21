//Leetcode 050 - Pow(x, n).java
//和 029 一起看

public class Solution {
	public static void main(String[] args){ 
	    Double res = pow(7.0, 5);
	    System.out.println(res + "");
	}
	
	public static Double pow(Double x, int n){
	    return (n>0) ? power(x, n) : 1/power(x, n); 
	}
	
	public static Double power(Double x, int n){
	    if(n==0) return 1.0;
	    if(n==1) return x;
	    Double temp = power(x, n/2);
	    return (n%2==0) ? temp * temp : temp * temp * x;
	}


}