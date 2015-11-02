Leetcode 135 - Candy -类似 042 两边扫.java

public class Solution {
    public static void main(String[] args){
        int[] ratings = {4,2,3,4,1};
        int candies = candy(ratings);
        System.out.println(candies + "");
      
    }
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        
        for(int i=1; i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }else{
                nums[i] = 1;
            }
        }
        
        int total = nums[ratings.length-1];
        for(int i=ratings.length-2; i>=0;i--){
            //关于这里为什么要这样处理，试一试{4,2,3,4,1}就可以知道
            if(ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]){
                nums[i] = nums[i+1]+1;
            }
            total += nums[i];
        }
        return total;
    }
}