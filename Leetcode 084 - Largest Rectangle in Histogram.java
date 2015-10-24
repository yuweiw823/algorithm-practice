Leetcode 084 - Largest Rectangle in Histogram.java
//和011不同，011 Container With Most Water 是 height[] 中的线作为木板，而不是直方，且011可以没过比自己低的板

http://blog.csdn.net/doc_sgl/article/details/11805519
Time - O(n)

public class Solution {
    public int largestRectangleArea(int[] height) {

        if(height==null || height.length==0)
            return 0;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[i]<=height[stack.peek()]) {
                int index = stack.pop();
                int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
                // 在每次退栈时，都计算一下以index处条向左向右能扩展的最大的矩阵面积
                // 每个条都必进栈一次，出栈一次，并在出栈时检查最大面积
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){ //记得清栈，必须保证每个条都检查过最大面积
            int index = stack.pop();
            int curArea = stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
            max = Math.max(max,curArea);            
        }
        return max;
    }
}