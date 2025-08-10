class Node {
    Node links [];
    boolean flag;

    public Node() {
        links = new Node[26];
    }

    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    public void setKey(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node getKey(char ch) {
        return links[ch-'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}


class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.setKey(ch, new Node());
            }

            node = node.getKey(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.getKey(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch: prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.getKey(ch);
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
