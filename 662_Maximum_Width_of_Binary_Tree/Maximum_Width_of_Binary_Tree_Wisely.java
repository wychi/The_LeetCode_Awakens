/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int size = 1;
        ArrayDeque<TreeNode> tnDQ1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> tnDQ2 = new ArrayDeque<>();
        ArrayDeque<Integer> valueDQ1 = new ArrayDeque<>();
        ArrayDeque<Integer> valueDQ2 = new ArrayDeque<>();
        tnDQ1.addLast(root);
        valueDQ1.add(0);
        while (!tnDQ1.isEmpty() || !tnDQ2.isEmpty()) {
            TreeNode temp = tnDQ1.removeFirst();
            int value = valueDQ1.removeFirst();
            if (temp.left != null) {
                tnDQ2.addLast(temp.left);
                valueDQ2.addLast(value * 2 + 1);
            }
            if (temp.right != null) {
                tnDQ2.addLast(temp.right);
                valueDQ2.addLast(value * 2 + 2);
            }
            if (tnDQ1.isEmpty()) {
                if (!tnDQ2.isEmpty()) {
                    size = Math.max(size, valueDQ2.getLast() - valueDQ2.getFirst() + 1);
                }
                tnDQ1 = tnDQ2;
                valueDQ1 = valueDQ2;
                tnDQ2 = new ArrayDeque();
                valueDQ2 = new ArrayDeque();
            }
        }
        return size;
    }
}

class Solution {
	private Map<Integer, List<Integer>> map = new HashMap<>();
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> temp = new ArrayList<>();
		traverse(root, 1, 0);
		int max = 1;
		for (int key : map.keySet()) {
			temp = map.get(key);
			if (temp.size() == 1) {
				max = Math.max(max, 1);
			} else if (temp.size() == 2) {
				max = Math.max(max, temp.get(1) - temp.get(0) + 1);
			}
		}
		return max;
	}

	public void traverse(TreeNode node, int level, int value) {
		if (node == null) {
			return;
		}
		List<Integer> temp;
		if (map.containsKey(level)) {
			temp = map.get(level);
		} else {
			temp = new ArrayList<>();
			map.put(level, temp);
		}
		if (node.left != null) {
			if (temp.size() < 2) {
				temp.add(value * 2 + 1);
			} else {
				int first = temp.remove(0);
				temp.clear();
				temp.add(first);
				temp.add(value * 2 + 1);
			}
		}
		if (node.right != null) {
			if (temp.size() < 2) {
				temp.add(value * 2 + 2);
			} else {
				int first = temp.remove(0);
				temp.clear();
				temp.add(first);
				temp.add(value * 2 + 2);
			}
		}
		traverse(node.left, level + 1, value * 2 + 1);
		traverse(node.right, level + 1, value * 2 + 2);
	}
}