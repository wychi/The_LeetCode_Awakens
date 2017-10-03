import java.util.*;

/**
 Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
  [
     [7],
     [2, 2, 3]
  ]
*/

class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates,
                                                     int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        List<Integer> current = new ArrayList<Integer>();

        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public static void combinationSum(int[] candidates, int target, int index,
                                      List<Integer> current,
                                      List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            System.out.println("match: " + current);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            System.out.println("target: " + target);
            if (target < candidates[i]) {
                return;
            }

            current.add(candidates[i]);
            System.out.println("candidate: " + candidates[i]);
            combinationSum(candidates, target - candidates[i], i, current, result);
            System.out.println("current: " + current);
            current.remove(current.size() - 1);
            System.out.println("current: " + current);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[] {2, 3, 6, 7}, 7);
        System.out.println("result: " + result);
    }
}
