class Trie {

    static class Node {
        Node[] nodes = new Node[26];
        boolean isWord;
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;
        for(int i=0; i<charArray.length; i++) {
            int idx = charArray[i] - 'a';
            Node tmp = node.nodes[idx];
            if(tmp == null) {
                tmp = new Node();
                node.nodes[idx] = tmp;
            }
            node = tmp;
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;
        for(int i=0; i<charArray.length; i++) {
            int idx = charArray[i] - 'a';
            Node tmp = node.nodes[idx];
            if(tmp == null) {
                return false;
            }
            node = tmp;
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Node node = root;
        for(int i=0; i<charArray.length; i++) {
            int idx = charArray[i] - 'a';
            Node tmp = node.nodes[idx];
            if(tmp == null) {
                return false;
            }
            node = tmp;
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
