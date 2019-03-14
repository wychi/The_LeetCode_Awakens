//addWord - O(m) - m is the length of the new word
//search - O(n) - n is the total number of characters in all words
class WordDictionary {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean leaf;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() <= 0) return;
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a']; //move forward
        }
        node.leaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int idx, TrieNode node) {
        if (idx == chs.length) {
            return node.leaf;
        }
        if (chs[idx] != '.') {
            return node.children[chs[idx]-'a'] != null && match(chs, idx+1, node.children[chs[idx]-'a']);
        } else {
            for (int i = 0 ; i<node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, idx+1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
