package org.example.trie;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();  //root is Empty
    }
    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];   //storing English alphabets(a - z)
            this.isWord = false;
        }
    }

    public void insert(String word){
        TrieNode node = root;

        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    public boolean search(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }
    public static void main(String[] args) {
        Trie tries = new Trie();
        tries.insert("example");
        System.out.println(tries.search("example"));    //returns true
        System.out.println(tries.search("exam"));   //returns false
    }
}
