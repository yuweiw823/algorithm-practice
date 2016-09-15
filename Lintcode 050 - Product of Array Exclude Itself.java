Leetcode 50 - Product of Array Exclude Itself.java

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
     
    //算法1：
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        Long totalProduct = Long.valueOf(1);
        for(Integer i : A) {
            totalProduct *= i;
        }
        
        ArrayList<Long> result = new ArrayList<Long>();
        
        for(int i = 0; i < A.size(); i++) {
            if(totalProduct == Long.valueOf(0)) {
                result.add(Long.valueOf(0));
            } else {
                result.add(totalProduct/Long.valueOf(A.get(i)));
            }
        }
        
        return result;
    }
}


public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() == 0) {
            return result;
        }
        
        int size = A.size();
        
        Long[] productFromLast = new Long[size];
        
        productFromLast[size-1] = Long.valueOf(A.get(size - 1));
        
        for(int i = size - 2; i >= 0; i--) {
            productFromLast[i] = productFromLast[i + 1] * A.get(i);
        }
        
        Long tmp = 1L;
        
           
        for(int i = 0; i < size - 1; i++) {
            Long curr = tmp * productFromLast[i + 1];
            result.add(curr);
            tmp *= A.get(i);
        }
        
        result.add(tmp);
        
        return result;
    }
}
