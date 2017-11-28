package com.demo;

import java.util.HashMap;

class TrieNode {

	public boolean isWord;
	public HashMap<Character, TrieNode> children;
	public int count;
	
	public TrieNode() {
		isWord = false;
		children = new HashMap<>(); // to avoid NPE
		count = 0;
	}

}

public class TriesImplementation {

	private final TrieNode root;

	public TriesImplementation() {

		root = new TrieNode();
	}

	public void addWord(String word) {

		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = current.children.get(character);
			if (node == null) {
				node = new TrieNode();
				node.count++;
				current.children.put(character, node);
			}else{
				node.count++;
			}
			current = node;
		} // loop ends
		current.isWord = true;
	}
	
	public int countWordsStartingWith(String word){
		int count = 0;
		TrieNode current = root;
		for(int i = 0 ; i < word.length() ; i++){
			char character = word.charAt(i);
			TrieNode node = current.children.get(character);
			if(node == null)
				return 0;
			else if(i == word.length() -1 ){
				
				count = node.count;
			}
			current = node;
		}
		return count;
	}
	
	
	public boolean searchCompleteWord(String word){
		
		TrieNode current = root;
		for(int i = 0 ; i < word.length() ; i++){
			char tempChar = word.charAt(i);
			TrieNode child = current.children.get(tempChar);
			if(child == null)
				return false;
			else if(i == word.length()-1 && child.isWord == true )
				return true;
			current = child;
		}
		return false;
	}
	

	public static void main(String[] args) {

		TriesImplementation obj = new TriesImplementation();
		obj.addWord("cat");
		obj.addWord("cats");
		obj.addWord("cathy");
		obj.addWord("catrat");
		obj.addWord("can");
		//obj.addWord("never");
		//obj.addWord("trie");
		System.out.println(obj.searchCompleteWord("can"));
		System.out.println(obj.countWordsStartingWith("c"));
		
	}
}
