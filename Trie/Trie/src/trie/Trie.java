package trie;

import java.util.HashMap;
import java.util.Map;

class Trie{
  static Node root;
  public static void main(String[] args) {
    root = new Node();
    insert("welcome");
    insert("welco");
    insert("qwqq");
    delete("welco",0,root);
    //delete("qwqq",0,root);
   // insert("welco");
    System.out.println(search("qwqq"));
  }
  
  static void insert(String word) {
    Node current = root;
    for(int i=0;i<word.length();i++) {
      if(!current.children.containsKey(word.charAt(i))) {
        current.children.put(word.charAt(i),new Node());
      }
      current = current.children.get(word.charAt(i));
    }
    current.endOfWord = true;
  }
  
  static boolean search(String word) {
    Node current = root;
    for(int i=0;i<word.length();i++) {
      if(current.children.containsKey(word.charAt(i))) {
        current = current.children.get(word.charAt(i));
      } else {
        return false;
      }
    }
    if(current.endOfWord) {
      return true;
    }
    return false;
  }
  
  static boolean delete(String word,int i,Node current) {
    if(i==word.length()) {
      if(!current.endOfWord) {
        return false;
      } else {
        current.endOfWord = false;
        return current.children.size() == 0;
      }
    }
    if(current.children.get(word.charAt(i)) == null) {
      return false;
    }
    boolean shouldDelete = delete(word,i+1,current.children.get(word.charAt(i)));
    if(shouldDelete) {
      current.children.remove(word.charAt(i));
      return current.children.size() == 0;
    }
    return false;
  }
  
}

class Node {
  Map<Character,Node> children;
  boolean endOfWord;
  Node() {
    children = new HashMap<Character, Node>();
    endOfWord = false;
  }
}



