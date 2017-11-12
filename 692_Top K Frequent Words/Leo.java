class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        final HashMap<String, Integer> map = new HashMap<>();
        for (String s:words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(words.length, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> l, Map.Entry<String, Integer> r) {
                int diff = l.getValue() - r.getValue();
                return diff != 0 ? diff : r.getKey().compareTo(l.getKey());
            }
        });
        int count = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
            if (count++ >= k) pq.poll();
        }
        LinkedList<String> ret = new LinkedList<>();
        while (!pq.isEmpty()) {
            ret.addFirst(pq.poll().getKey());
        }
        return ret;                           
    }
}
