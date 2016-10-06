//Leetcode 056 - Merge Intervals - 仿 stack 结构,排序override.java

import java.util.*;

// 可能会出现的三种情况：
// [1, 2],[3, 4] - ok
// [1, 3],[2, 4] - [1,4]
// [1, 4],[2, 3] - [1,4]

    
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int i = 0;
        while(i < intervals.size() - 1) {
        Interval curr = intervals.get(i);
        Interval next = intervals.get(i+1);
            if(curr.end >= next.start) {
                int max = Math.max(curr.end, next.end);
                curr.end = max;
                intervals.remove(i+1);
            } else {
                i++;
            }
        }
        
        return intervals;
    }
}
  
public static class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}
