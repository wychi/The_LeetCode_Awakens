package com.myleetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LeetCode347 {
    public static void main(String[] args) {
        // write your code here
        int[] data = new int[]{1, 1, 1, 2, 3, 4, 5, 2, 1, 2, 3, 4, 5, 1, 2, 3, 2, 2, 3};
        LeetCode347 obj = new LeetCode347();
        List<Integer> list = obj.topKFrequent(data, 2);
        System.out.println("result");
        for (int n : list) {
            System.out.println(n);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> rank = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (rank.containsKey(value)) {
                rank.get(value).add(key);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                rank.put(value, list);
            }
        }

        int count = 0;
        for (int key : rank.descendingKeySet()) {
            List<Integer> list = rank.get(key);
            for (int n : list) {
                res.add(n);
                count++;
                if (count == k) {
                    break;
                }
            }
            if (count == k) {
                break;
            }
        }

        return res;
    }
}
