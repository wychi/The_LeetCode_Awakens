package com.myleetcode;

import com.myleetcode.data.Interval;

import java.util.*;

public class LeetCode056 {
    public static void main(String[] args) {
        // write your code here
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 7));
        list.add(new Interval(2, 3));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        LeetCode056 obj = new LeetCode056();
        List<Interval> r = obj.merge2(list);
        for (Interval i : r) {
            System.out.println("[" + i.start + ", " + i.end + "]");
        }

    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return merged;
        } else if (intervals.size() == 1) {
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        Interval p = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval t = intervals.get(i);
            if (p.end >= t.start) {
                p.end = Math.max(p.end, t.end);
            } else {
                merged.add(p);
                p = t;
            }
        }
        merged.add(p);

        return merged;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
