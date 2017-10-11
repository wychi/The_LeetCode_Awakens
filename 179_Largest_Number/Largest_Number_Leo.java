class Solution {
    public String largestNumber(int[] nums) {
        int size = nums.length;
        String[] numsString = new String[size];
        for (int i = 0; i < size; i++) {
            numsString[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(numsString, new Comparator<String>(){
           public int compare(String l, String r) {
                return (r+l).compareTo(l+r);
           } 
        });
        if ("0".equals(numsString[0])) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s:numsString) {
            sb.append(s);
        }
        return sb.toString();
    }
}
