/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//Time:O(NlogN)
//Space:O(N)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (null == intervals || intervals.length <= 0)
            return 0;
        
        Integer[] startT = new Integer[intervals.length];
        Integer[] endT = new Integer[intervals.length];
        int i = 0;
        for (Interval v: intervals) {
            startT[i] = v.start;
            endT[i] = v.end;
            i++;
        }
        
        Arrays.sort(startT, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v1-v2;
            }
        });
        Arrays.sort(endT, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v1-v2;
            }
        });
        
        int room = 0;
        int startIdx=0, endIdx=0;
        while (startIdx < intervals.length) {
            if (startT[startIdx] >= endT[endIdx]) {
                room--;
                endIdx++;
            }
            room++;
            startIdx++;
        }
        
        return room;
    }
}
