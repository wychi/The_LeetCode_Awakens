class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n1=0, n2=0;
        int n1c=0;
        int n2c=0;
        for (int num : nums) {
            if (num == n1) {
                n1c++;
            } else if (num == n2) {
                n2c++;
            } else {
                if (n1c==0) {
                    n1 = num;
                    n1c++;
                } else if (n2c==0) {
                    n2=num;
                    n2c++;
                } else {
                    n1c--;
                    n2c--;
                }
            }
        }
        n1c=0; n2c=0;
        for (int num : nums) {
            if (num == n1) n1c++;
            else if (num == n2) n2c++;
        }
        if (n1c>nums.length/3)
            result.add(n1);
        if (n2c>nums.length/3)
            result.add(n2);
        return result;
        
    }
}