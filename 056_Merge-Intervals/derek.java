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
	//Method 1: better
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return Integer.compare(v1.start, v2.start);
            }
        });
        LinkedList<Interval> result = new LinkedList<>();
        for (Interval interval: intervals) {
            if (result.isEmpty() || result.getLast().end < interval.start) {
                result.add(interval);
            } else {
                result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
        }

        return result;
    }

    //Key:
    //1. Sort by start
    //
    //Time:O(N logN)
    //Space:O(N)
    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || intervals.size() <= 1) {
            return intervals;
        }
        //Time: O(N logN)
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        };
        Collections.sort(intervals, comparator);

        List<Interval> result = new ArrayList<Interval>();
        result.add(intervals.get(0));
        for (int i = 1; i<intervals.size(); i++) {
            //case (1, 4), (2, 5)
            //case (1, 4), (2, 3)
            if (intervals.get(i).start <= result.get(result.size()-1).end) {
                if (intervals.get(i).end >= result.get(result.size()-1).end) {
                    result.get(result.size()-1).end = intervals.get(i).end;
                    result.set(result.size()-1, result.get(result.size()-1));
                }
            } else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }
}
