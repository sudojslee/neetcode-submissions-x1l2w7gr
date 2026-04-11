class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // can be anything
                for (TrieNode node : current.children) {
                    if (node != null) {
                        // System.out.println(word.substring(i + 1));
                        if (search(word.substring(i + 1), node)) {
                            return true;
                        }
                    }
                }

                return false;
            }
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];

        }

        return current.isEndOfWord;
    }

    public boolean search(String word, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // can be anything
                for (TrieNode node : current.children) {
                    if (node != null) {
                        // System.out.println(word.substring(i + 1));
                        if (search(word.substring(i + 1), node)) {
                            return true;
                        }
                    }
                }

                return false;
            }
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];

        }

        return current.isEndOfWord;
    }

    class TrieNode {
        
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
}
