public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || null != curr) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }            
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
