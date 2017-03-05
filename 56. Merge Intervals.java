/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){  //重写comparator
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int i = 0;
        while(i < intervals.size() - 1){    //因为用了i + 1, 所以让它在倒数第二个就停止
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if(cur.end >= next.start){
                int max = Math.max(cur.end, next.end);
                cur.end = max;
                intervals.remove(i + 1);   //如果重合了，就remove掉
            }else{
                i++;
            }
        }
        return intervals;
    }
}
