package com.myleetcode;

import java.util.*;

public class LeetCode049 {
    public static void main(String[] args) {
        final String[] data = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        LeetCode049 obj = new LeetCode049();
        obj.print(obj.groupAnagrams(data));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>(strs.length);
        if (strs != null && strs.length > 0) {
            Map<String, List<String>> map = new HashMap<>(strs.length);
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (map.containsKey(key)) {
                    map.get(key).add(s);
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(s);
                    map.put(key, l);
                }
            }
            for (List<String> l : map.values()) {
                list.add(l);
            }
        }

        return list;
    }

    public void print(List<List<String>> list) {
        for (List<String> l : list) {
            ListIterator<String> iter = l.listIterator();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (iter.hasNext()) {
                sb.append(iter.next());
                if (iter.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
