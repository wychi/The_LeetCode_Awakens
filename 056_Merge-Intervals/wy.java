/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                // Note: Comparison method violates its general contract!
                if(a.start == b.start)
                    return 0;
                return a.start < b.start ? -1 : 1;
            }
        });
        
        List<Interval> result = new ArrayList<>();
        Interval top = null;
        for(int i=0;i<intervals.size(); i++) {
            Interval t = intervals.get(i);
            if(top == null) {
                top = new Interval(t.start, t.end);
            } else {
                if(top.end >= t.start && top.end < t.end) {
                    top.end = t.end;
                } else if(top.end < t.start) {
                    result.add(top);
                    top = new Interval(t.start, t.end);
                }
            }
        }
        if(top != null)
            result.add(top);
        
        return result;
    }
}
