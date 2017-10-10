class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
        	return 0;
        }
        if (p.length() == 1) {
        	return 1;
        }
        int[] charMap = new int[26];
        int maxLength = 1;
        int length = p.length();
        int itemLength = 1;
        char start = p.charAt(0);
        char last = start;
        for (int i = 1; i < length; i++) {
        	char current = p.charAt(i);
        	if ((current - last == 1 || (current - last == -25 && current == 'a'))) {
        		itemLength++;
        		last = current;
        	} else {
        		updateMap(charMap, start, itemLength);
        		if (itemLength > maxLength) {
        			maxLength = itemLength;
        		}
        		itemLength = 1;
        		start = current;
                last = start;
        	}
        }
        updateMap(charMap, start, itemLength);
        if (itemLength > maxLength) {
        	maxLength = itemLength;
        }
        return countSubString(charMap, maxLength);
    }
    
    private void updateMap(int[] charMap, char key, int length) {
    	charMap[key-'a'] = Math.max(charMap[key-'a'], length);
    }
    
    private int countSubString(int[] charMap, int maxLength) {
    	int clearLevel = maxLength >= 26 ? maxLength - 26 + 1 : 0;
    	Map<String, Boolean> resultMap = new HashMap<>();
    	for (int index = 0; index < 26; index++) {
    		int itemLength = charMap[index];
    		for (int i = clearLevel + 1; i <= itemLength; i++) {
    			for (int pos = 0; pos < itemLength - i + 1; pos++) {
    				char key = (char)('a' + index + (pos % 26));
    				if (key > 'z') {
    					key = (char) (key - 'z' + 'a' - 1);
    				}
    				resultMap.put("" + key + "-" + i, true);
    			}
    		}
    	}
    	return resultMap.size() + clearLevel * 26;
    }
}