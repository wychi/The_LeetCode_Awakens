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
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return Integer.compare(i1.start, i2.start);
                }
                return Integer.compare(i1.end, i2.end);
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval interval = intervals.remove(0);
        int start = interval.start; int end = interval.end;
        while (intervals.size() > 0) {
            interval = intervals.remove(0);
            if (interval.start > end) {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}