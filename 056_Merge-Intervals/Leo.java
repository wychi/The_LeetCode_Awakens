class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval l, Interval r) {
                return l.start - r.start;
            }
        });
        LinkedList<Interval> ret = new LinkedList<>();
        Interval prev = intervals.get(0);
        ret.add(prev);
        for (Interval iv: intervals) {
            if (prev.end >= iv.start) {
                prev.end = Math.max(prev.end, iv.end);
            } else {
                ret.add(iv);
                prev = iv;
            }
        }        
        return ret;        
    }
}
