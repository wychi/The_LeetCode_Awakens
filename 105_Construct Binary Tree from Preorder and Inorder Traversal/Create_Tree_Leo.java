class Solution {
    public TreeNode buildTree(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int idx = map.get(node.val);
        node.left = buildTree(preorder, ++preStart, inStart, idx-1, map);
        node.right = buildTree(preorder, preStart + (idx - inStart), idx+1, inEnd, map);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0, size =  inorder.length; i < size; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, 0, inorder.length - 1, map);
        return root;
    }
}
