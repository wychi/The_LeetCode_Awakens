/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //Key:
    //1. Binary search 
    //Time:  O(logN)
    //Space: O(1)
    public int firstBadVersion(int n) {
        int mid = 0;
        int start = 0, end = n;
        while (start < end) {
            mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
