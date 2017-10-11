class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>();
        for (int num : nums) {
            numStrings.add("" + num);
        }
        Collections.sort(numStrings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
        String result = "";
        for (String numString : numStrings) {
            result += numString;
        }
        int remove0 = 0;
        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == '0') {
                remove0++;
            } else {
                break;
            }
        }
        return result.substring(remove0);
    }
}