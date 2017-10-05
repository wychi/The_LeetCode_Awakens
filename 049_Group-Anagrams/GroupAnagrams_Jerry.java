package com.example.starlitya.onlineassement.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

 */
public class Group_Anagrams_Jerry {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String source: strs) {
            char [] chars = source.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // back to String

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(source);
        }

        /* List<List<String>> result = new ArrayList<>();
        for (HashMap.Entry entry : map.entrySet()) {
            result.add((ArrayList<String>)entry.getValue());
        }
        return result; */
        return new ArrayList<List<String>>(map.values());
    }

}