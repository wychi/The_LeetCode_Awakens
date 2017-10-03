public class Solution {
    /*
    * Author: Leo Lu
    * Q1. What should do if we have two the same string??
    * Q2. What should we deal with empty string??
    * Q3. May we have a word with duplicate letter??
    * Time: O(Length of total strings+n) or O(n_avg+n) where n_avg is the average of input string, 
    * Space:O(n)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ret = new LinkedList<>();
        for (String str:strs) {
            char[] key = new char[26];
            for (int i = 0, size = str.length(); i < size; i++ ){
                key[str.charAt(i) - 'a']++;
            }
            String keyStr = new String(key);
            List<String> list = map.get(keyStr);
            if (null == list) {
                list = new LinkedList<>();
                map.put(keyStr, list);
                ret.add(list);
            }
            list.add(str);
        }
        return ret;
    }
}
