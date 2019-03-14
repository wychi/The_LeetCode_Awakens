//Iterative
public void flatten(TreeNode root) {
        TreeNode now = root;
		while (now!= null)
		{
			if(now.left != null)
			{
                //Find current node's prenode that links to current node's right subtree
				TreeNode pre = now.left;
				while(pre.right!= null)
				{
					pre = pre.right;
				}
				pre.right = now.right;
                //Use current node's left subtree to replace its right subtree(original right 
                //subtree is already linked by current node's prenode
				now.right = now.left;
				now.left = null;
			}
			now = now.right;
		}
    }

//Resursive
//Time:O(N)
//Space:O(N)
public void flatten(TreeNode root) {
     if(root == null)
 	return;
 	
     flatten(root.left);
     flatten(root.right);
 
     // save current right for concatination
     TreeNode right = root.right;
 
     if(root.left != null) {
     
         // step 1: concatinate root with left flatten subtree
     	root.right = root.left;
     	root.left = null; // set left to null
 	
     	// step 2: move to the end of new added flatten subtree
     	while(root.right != null)
     		root = root.right;
 		
     	// step 3: contatinate left flatten subtree with flatten right subtree	
     	root.right = right;
     }
 }
