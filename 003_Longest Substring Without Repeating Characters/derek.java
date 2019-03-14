class Solution {
	//Time: O(N)
    //Space:O(min(m, n))
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int j =0 , i=0; j<s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    //Time:O(2N) => O(N)
    //Space:O(min(m, n))
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0, j= 0, ans = 0, n = s.length();
        while (i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
