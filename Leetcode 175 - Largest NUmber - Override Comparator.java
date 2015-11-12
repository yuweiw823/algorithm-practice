Leetcode 175 - Largest NUmber - Override Comparator.java

public class Solution {
    public String largestNumber(int[] nums) {
        int max = 0;
        String res = "";
        String[] V = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            if(max < nums[i]) max = nums[i];  //max 用于查0 
            V[i] = nums[i] + "";
        }
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        };
        
        Arrays.sort(V, comp);
        for(int i=0; i<nums.length; i++){
            res += V[i];
        }
        
        return max == 0 ? "0" : res;、
    }
    
}