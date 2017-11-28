package com.demo;

import java.util.HashMap;

class TrieNode {

	public boolean isWord;
	public HashMap<Character, TrieNode> children;

	public TrieNode() {
		isWord = false;
		children = new HashMap<>(); // to avoid NPE
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
				current.children.put(character, node);
			}
			current = node;
		} // loop ends
		current.isWord = true;
	}

	public static void main(String[] args) {

		TriesImplementation obj = new TriesImplementation();
		obj.addWord("cat");
		obj.addWord("cats");
		
	}
}
