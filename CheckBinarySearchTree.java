package com.demo;

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

}

public class CheckBinarySearchTree {

	public static void main(String[] args) {

	}

	boolean checkBST(Node root) {

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean checkBST(Node root, int min, int max) {

		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);

	}

}
