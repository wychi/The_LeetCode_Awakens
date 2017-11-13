class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            int count = map.getOrDefault(words[i], 0);
            map.put(words[i], count+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1,
                               Map.Entry<String, Integer> entry2){
                int ret = entry1.getValue().compareTo(entry2.getValue());
                
                return ret != 0 ? ret : -(entry1.getKey().compareTo(entry2.getKey()));
            }
        });
        
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            heap.offer(e);
            if(heap.size() > k)
                heap.poll();
        }
        
        ArrayList<String> result = new ArrayList<>(k);
        while(!heap.isEmpty()) {
            Map.Entry<String, Integer> e = heap.poll();
            result.add( 0, e.getKey() );
        }
        
        return result;
            
    }
}
