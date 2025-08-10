Question: 

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
void erase(String word) Erases the string word from the trie.
 

Example 1:

Input
["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsStartingWith"]
[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], ["apple"], ["app"]]
Output
[null, null, null, 2, 2, null, 1, 1, null, 0]

Explanation
Trie trie = new Trie();
trie.insert("apple");               // Inserts "apple".
trie.insert("apple");               // Inserts another "apple".
trie.countWordsEqualTo("apple");    // There are two instances of "apple" so return 2.
trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
trie.erase("apple");                // Erases one "apple".
trie.countWordsEqualTo("apple");    // Now there is only one instance of "apple" so return 1.
trie.countWordsStartingWith("app"); // return 1
trie.erase("apple");                // Erases "apple". Now the trie is empty.
trie.countWordsStartingWith("app"); // return 0
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
It is guaranteed that for any function call to erase, the string word will exist in the trie.



Solution: 

class Node {
    Node links[];
    int cw;
    int cp;

    public Node() {
        links = new Node[26];
        cw = 0;
        cp = 0;
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

    public void deleteKey(char ch) {
        links[ch-'a'] = null;
    }
    
}


class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.setKey(ch, new Node());
            }
            node = node.getKey(ch);
            node.cp+=1;
        }

        node.cw+=1;
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.getKey(ch);
        }

        return node.cw;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.getKey(ch);
        }

        return node.cp;
    }
    
    public void erase(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return;
            }
            node = node.getKey(ch);
            node.cp-=1;
            if (node.cp == 0) {
                node.deleteKey(ch);
            }
        }

        node.cw-=1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */




