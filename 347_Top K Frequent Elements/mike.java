class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> [] bucket = new List[nums.length+1];

        for (int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i],map.get(nums[i])+1);
        }

        List<Integer> list = new ArrayList();

        int [] result = new int[k];
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            //System.out.print("map key = " + key + ", val = "+ val);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos=bucket.length-1;pos >=0 && res.size()<k;pos--) {
            if (bucket[pos] != null) {
                //System.out.print("bucket pos = " + pos + ", bucket[pos] = " + bucket[pos]);
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }
}
