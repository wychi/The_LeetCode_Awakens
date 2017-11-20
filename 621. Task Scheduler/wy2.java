class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
            (a, b) -> {
                return -a.getValue().compareTo(b.getValue());
            });
        queue.addAll(map.entrySet());
        
        int count = 0;
        while(!queue.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> tmpList = new ArrayList<>();
            
            while(k > 0 && !queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();
                entry.setValue(entry.getValue() - 1);
                if(entry.getValue() > 0) {
                    tmpList.add(entry);
                }
                
                k--;
                count++;
            }
            
            if(!tmpList.isEmpty()) {
                count += k;
                queue.addAll(tmpList);
            }
        }
        
        return count;
        
    }
    
    // https://discuss.leetcode.com/topic/92952/python-straightforward-with-explanation/7
    public int leastInterval2(char[] tasks, int n) {
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
