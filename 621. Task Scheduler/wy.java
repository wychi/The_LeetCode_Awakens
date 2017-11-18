class Solution {
    // https://discuss.leetcode.com/topic/92952/python-straightforward-with-explanation/7
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c-'A']++;
        }
        
        Arrays.sort(freq);
        int i = 24;
        while(i >= 0 && freq[i] == freq[25]) i--;
        
        int frame = freq[25];
        int len = n+1;
        int itemForLastFrame = (25 - i);
        
        /**
        c[25]-1: we have totally "c[25]" frames,
        *(n+1): the length of each frame, each of the first c[25]-1 frames must have a length of "n+1"
        +25-i: count for the most frequent letters, it is the length of the last frame
        */
        return Math.max(tasks.length, (frame-1) * len + itemForLastFrame);
    }
}
