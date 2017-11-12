class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, ++count);
        }
        PriorityQueue<Map.Entry<String, Integer>> p = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue()==b.getValue()) return b.getKey().compareTo(a.getKey());
                return a.getValue()-b.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            p.offer(entry);
            if (p.size() > k) {
                p.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!p.isEmpty()) {
            result.add(0, p.poll().getKey());
        }
        return result;
    }
}