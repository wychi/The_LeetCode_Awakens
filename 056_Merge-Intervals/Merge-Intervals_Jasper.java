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
        
        if(intervals.size() == 1) {
            return intervals;
        }
        
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        List<Interval> result = new ArrayList<>();
        boolean stable = false;
        while(!stable) {                      
            stable = true;
            for(int i=0;i<intervals.size();i++) {
                
                if(i == intervals.size() - 1) {
                    result.add(intervals.get(i));                    
                } else {
                    Interval newInterval = doMerge(intervals.get(i), intervals.get(i+1));
                    if(newInterval!=null) {
                        result.add(newInterval);
                        stable = false;
                        i++;
                    } else {
                        result.add(intervals.get(i));
                    }
                }
            }
            
            if(!stable) {
                intervals = result;
                result = new ArrayList<>();
            }
        }
       
        return result;
    }
    
    private Interval doMerge(Interval a, Interval b) {
        
        if(b.start < a.start) {
            Interval tmp = a;
            a = b;
            b = tmp;
        }
        
        if(a.end >= b.start) {
            return new Interval(a.start, Math.max(b.end, a.end));
        } else {
            return null;
        }
        
    }
}