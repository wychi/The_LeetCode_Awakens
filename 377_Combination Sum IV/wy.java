/**
[1, 2, 3], 4
f(4) = f(3) + f(2) + f(1)
f(n) = f(n-i1) + f(n-i2) + f(n-i3)
*/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        return calc(nums, target, map);
    }
    
    private int calc(int[] nums, int target, Map<Integer, Integer> map) {
        //System.out.println("["+ target + "]");
        
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > target) {
                break;
            } else if(nums[i] == target) {
                sum++;
            } else {
                int key = target-nums[i];
                //System.out.println("["+ target + "] next=" + key);
                int count = 0;
                if(map.containsKey(key)) {
                    count = map.get(key);
                } else {
                    count = calc(nums, key, map);
                    map.put(key, count);
                }
                sum += count;
            }
        }
        
        return sum;
    }
}

