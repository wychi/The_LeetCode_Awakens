class Solution {
    // worst: O(m + n)
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int freq[] = new int[26];
        for (int i = 0; i < len1; ++i) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        if (isArrayEmpty(freq)) {
            return true;
        }

        for (int i = len1; i < len2; ++i) {
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - len1) - 'a']++;
            if (isArrayEmpty(freq)) {
                return true;
            }
        }
        return false;
    }

    public boolean isArrayEmpty(int[] freq) {
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    // worst: O(mn)
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        // Build table1
        int freq1[] = new int[26];
        for (int i = 0; i < len1; ++i) {
            freq1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i + len1 - 1 < len2; ++i) {
            // Build table2
            int freq2[] = new int[26];
            for (int j = 0; j < len1; ++j) {
                freq2[s2.charAt(i + j) - 'a']++;
            }

            // Compare
            if (isArrayEqual(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isArrayEqual(int[] freq1, int[] freq2) {
        for (int i = 0; i < freq1.length; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
