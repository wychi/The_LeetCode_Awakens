class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length()==0) return false;
        String[] ps = preorder.split(",");
        if (ps.length==1) return ps[0].equals("#");
        if (ps.length<3) return false;
        if (ps[0].equals("#") || !ps[ps.length-1].equals("#") || !ps[ps.length-2].equals("#")) return false;
        int c = 1;
        for (int i=0; i<ps.length; i++) {
            if (--c<0) return false;
            if (!ps[i].equals("#")) {
                c+=2;
            }
        }
        return c==0;
    }
}

/*class Solution {
    class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        public TreeNode(String v) {
            val = v;
        }
    }
    
    public boolean isValidSerialization(String preorder) {
        if (preorder.length()==0) return false;
        String[] ps = preorder.split(",");
        if (ps.length==1) return ps[0].equals("#");
        if (ps.length<3) return false;
        if (ps[0].equals("#") || !ps[ps.length-1].equals("#") || !ps[ps.length-2].equals("#")) return false;
        Stack<TreeNode> tn = new Stack<>();
        TreeNode current = null;
        for (String p : ps) {
            System.out.println(p);
            if (!p.equals("#")) {
                TreeNode temp = new TreeNode(p);
                if (current==null) {
                    current = temp;
                } else if (current.left==null) {
                    current.left=temp;
                    tn.push(current);
                } else if (current.right==null) {
                    current.right=temp;
                } else {
                    return false;
                }
                current=temp;
            } else {
                TreeNode temp = new TreeNode(p);
                if (current==null) {
                    return false;
                } else if (current.left==null) {
                    current.left=temp;
                } else if (current.right==null) {
                    current.right=temp;
                    current=tn.isEmpty() ? current : tn.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}*/