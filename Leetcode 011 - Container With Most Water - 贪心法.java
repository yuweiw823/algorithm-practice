// Leetcode 011 - Container With Most Water - 贪心法.java
// 和 015 的移动指针的方法是同一种，注意比较


public class Solution{
    public static void main(String[] args){
        int[] height = {2,4,3,5};
        int result1 = maxArea1(height);
        int result2 = maxArea2(height);
        System.out.println(result1 + "");
        System.out.println(result2 + "");
      
    }
  
    public static int maxArea1(int[] height) {
        //写的逐个比较法，但很明显，太慢了
        int maxWater = 0;
        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; j<height.length; j++){
                int containsWater = Math.min(height[i], height[j]) * (j-i);
                maxWater = Math.max(maxWater,containsWater);
            }
        }
        return maxWater;
    }
  
    public static int maxArea2(int[] height) {
        //贪心法，两边指针向中间移，到最高点会合
        int maxWater = 0;
        int L = 0;
        int R = height.length-1;
        
        while(L<R){
            int containsWater = Math.min(height[R], height[L]) * (R-L);
            maxWater = Math.max(maxWater, containsWater);
            if(height[L] < height[R]) L++;//两边指针向中间移，到最高点会合
            else R--;
        }
        return maxWater;
    }  
}