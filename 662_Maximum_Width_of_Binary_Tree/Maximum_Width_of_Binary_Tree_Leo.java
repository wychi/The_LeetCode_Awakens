class Solution {
    private int widthOfBinaryTree(TreeNode root, int id, int level, ArrayList<Integer> left, int width) {
        if (null == root) return width;
        if (left.size() == level) left.add(id);
        width = Math.max(width, id - left.get(level) + 1);
        id <<= 1;
        level++;
        width = widthOfBinaryTree(root.left, id, level, left, width);
        return widthOfBinaryTree(root.right, id+1, level, left, width);
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTree(root, 0, 0, new ArrayList<>(), 0);
    }
}
