//Leetcode 056 - Merge Intervals - 仿stack结构,排序override.java

import java.util.*;

// 可能会出现的三种情况：
// [1, 2],[3, 4] - ok
// [1, 3],[2, 4] - [1,4]
// [1, 4],[2, 3] - [1,4]

public class Solution {
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<Interval>();
        Interval i1 = new Interval(2, 3);
        intervals.add(i1);
        Interval i2 = new Interval(2, 2);
        intervals.add(i2);
        Interval i3 = new Interval(1, 3);
        intervals.add(i3);
        Interval i4 = new Interval(5, 7);
        intervals.add(i4);
        Interval i5 = new Interval(4, 6);
        intervals.add(i5);
      
        List<Interval> res = new ArrayList<Interval>();
        res = merge(intervals);
      
        for(Interval i : res){
            System.out.println("[" + i.start + "," + i.end + "]");
        }
    }
    
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size() == 0) return intervals;
        List<Interval> stack = new ArrayList<Interval>();
        
        //便于理解，stack中的是 Interval1(start1，end1), 即将拿来比较的是 Interval2(start2，end2);
        //先根据start排序,光每次拿 Interval1 和 Interval2 比较，无法真正排序
        //定义了一个新的Comparators
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                //实现从小到大的排序功能，小的放前面
                return i1.start - i2.start;   
            }
        };
        Collections.sort(intervals, comp);
        
        stack.add(intervals.get(0));
        for(int i=0; i<intervals.size(); i++){
            //如果 end1 < start2，则在start中取min，(但由于之前已经完全排序，所以这一步其实不用做)
            //只需在end中取max，推入结果中
            if(stack.get(stack.size()-1).end >= intervals.get(i).start){
                stack.get(stack.size()-1).end = Math.max(stack.get(stack.size()-1).end, intervals.get(i).end);
            } else {
                stack.add(intervals.get(i));
            }
        }
        return stack;
    }
  
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}