class Trie {

    class TreeNode {
        char val;
        boolean isEndOfWord;
        List<TreeNode> next;        
        public TreeNode(char v) {
            val = v;
            next = new ArrayList<>();
        }
        
        public void addNode(TreeNode node) {
            next.add(node);
        }
        
        public void addWord(char[] chars, int start)  {
            if(start == chars.length) {
                return;
            }
            
            boolean found = false;
            for(TreeNode node:next) {
                if(node.val == chars[start]) {
                    if(start == chars.length - 1) {
                        node.isEndOfWord = true;
                    }                    
                    node.addWord(chars, start+1);
                    found = true;
                } 
            }
                
            if(!found) {
                addNewNode(chars, start);
            }
        }
        
        private void addNewNode(char[] chars, int start) {
            TreeNode node = new TreeNode(chars[start]);
            if(start == chars.length - 1) {
                node.isEndOfWord = true;
            } 
            next.add(node);
            node.addWord(chars, start+1);
        }
        
        public boolean search(char[] chars, int start) {
            
            for(TreeNode node:next) {
                if(node.val == chars[start]) {                    
                    if(start < chars.length - 1) {                    
                        return node.search(chars, start+1);    
                    } else {
                        return node.isEndOfWord;
                    }                    
                } 
            }
            return false;
        }
        
        public boolean startsWidth(char[] chars, int start) {
            if(start == chars.length) {
                return true;
            }
            
            for(TreeNode node:next) {
                if(node.val == chars[start]) {
                    return node.startsWidth(chars, start+1);
                } 
            }
            return false;
        }
    }
    
    private TreeNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.addWord(word.toCharArray(), 0);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWidth(prefix.toCharArray(), 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */