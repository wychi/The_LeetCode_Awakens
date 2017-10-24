class Solution {
    //bucket sort
    //Time: O(N)
    //Space: O(N)
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
    //Key:
    // Time is Bad
    // HashMap + PriorityQueue
    //Time: O(N logK)
//     public List<Integer> topKFrequent(int[] nums, int k) {
        
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for (int i : nums) {
//             map.put(i, map.getOrDefault(i, 0)+1);
//             // if (!map.containsKey(i)) {
//             //     map.put(i, 1);
//             // } else {
//             //     map.put(i, map.get(i)+1);
//             // }
//         }
        
//         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
//         for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//             pq.offer(entry); //O(log K)
//             if (pq.size() > k) pq.poll(); 
//         }
//         List<Integer> result = new ArrayList<>();
//         while (!pq.isEmpty()) {
//             result.add(pq.poll().getKey());
//         }
//         return result;
//     }
}
