//Leetcode 057 - Insert Interval - 和56一样的方法,排序override.java

import java.util.*;

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
        res = insert(intervals, new Interval(6, 8));
      
        for(Interval i : res){
            System.out.println("[" + i.start + "," + i.end + "]");
        }
    }
    
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        
        intervals.add(newInterval);
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, comp);
        
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start <= res.get(res.size()-1).end){
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
            } else {
                res.add(intervals.get(i));
            }
        }
        
        return res;
    }
  
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}