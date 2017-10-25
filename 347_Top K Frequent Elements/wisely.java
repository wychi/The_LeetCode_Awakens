class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
        	maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(nums.length, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() > o2.getValue()) return -1;
				if (o1.getValue() == o2.getValue()) return 0;
				return 1;
			}
		});
        for (Map.Entry<Integer, Integer> e : maps.entrySet()) {
        	pq.offer(e);
        }
        List<Integer> result = new ArrayList<>();
        int c = 0;
        Map.Entry<Integer, Integer> e;  
        while ((e = pq.poll()) != null && c < k) { // default is ascending order.  
        	result.add(e.getKey());
            c++;
        }  
        return result;
    }
}