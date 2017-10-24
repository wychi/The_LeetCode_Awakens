class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            int count = 0;
            if(map.containsKey(n)) {
                count = map.get(n);
            }
            map.put(n, count+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for(Integer key : map.keySet()) {
            Integer freq = map.get(key);
            
            ArrayList<Integer> list;
            if(map2.containsKey(freq)) {
                list = map2.get(freq);
                list.add(key);
            } else {
                list = new ArrayList<>();
                list.add(key);
                map2.put(freq, list);
            }
            
            heap.offer(freq);
            while(heap.size() > k) {
                heap.poll();
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!heap.isEmpty()) {
            int freq = heap.poll();
            while(!heap.isEmpty() && freq == heap.peek())
                heap.poll();
            result.addAll(map2.get(freq));
        }
        
        return result;
        
    }
}
