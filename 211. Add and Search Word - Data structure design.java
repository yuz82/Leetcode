/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class WordDictionary {
    class TrieNode{
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){}
        TrieNode(char c) { val = c; }
    }

    TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        int n = word.length();
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if(node.children[c-'a']==null){ node.children[c-'a'] = new TrieNode(c); }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    public boolean helper(String word, int i, TrieNode node){
        if(i==word.length()) { return node.isWord; }
        char c = word.charAt(i);
        if(c!='.') { 
            if(node.children[c-'a']!=null){ 
                return helper(word, i+1, node.children[c-'a']); 
            }
        }
        else{
            for(int j=0;j<26;j++){
                if(node.children[j]==null) { continue; }
                if(helper(word, i+1, node.children[j])) { return true; }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
