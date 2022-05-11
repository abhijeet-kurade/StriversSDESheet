package Trie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TrieClass {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>(map);

        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("abhijeet");
        trie.insert("abhijaet");
        trie.insert("akanksha");
        trie.insert("abhilasha");
        trie.insert("abhinav");
        trie.insert("akash");
        trie.insert("abhi");

        String word = "abhijeet";
        for(int i=3; i<=word.length(); i++){
            System.out.println(trie.suggestions(word.substring(0, i)));
        }
    }
}

class Trie{
    Node root;
    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }
    public Trie() {
        this.root = new Node();
    }
    public void insert(String word){
        Node node = this.root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null)  node.children[idx] = new Node();
            node =  node.children[idx];
        }
        node.isWord = true;
    }
    public boolean search(String word){
        Node node = this.root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isWord;
    }
    public ArrayList<String> suggestions(String word){
        Node node = this.root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null) return new ArrayList<>();
            node = node.children[idx];
        }
        ArrayList<String> suggestions = new ArrayList<>();
        suggestions(node, new StringBuilder(word), suggestions);
        return suggestions;
    }
    public void suggestions(Node node, StringBuilder string, ArrayList<String> suggestions){
        if(node == null) return;
        if(node.isWord) suggestions.add(String.valueOf(string));
        for(int i=0; i<26; i++){
            Node child = node.children[i];
            if(child == null) continue;
            string.append((char)(i+'a'));
            suggestions(child, string, suggestions);
            string.deleteCharAt(string.length()-1);
        }
    }

}
