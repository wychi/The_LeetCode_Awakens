class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        for(int i:nums) {
            numFreq.put(i,numFreq.getOrDefault(i,0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>()         {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });        
        
        HashMap<Integer, List<Integer>> freqToNumMap = new HashMap<Integer, List<Integer>>();
                
        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            maxHeap.offer(entry);
        }
        
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<k;i++) {
            result.add(maxHeap.poll().getKey());
        }
                
        return result;
    }
    
}
