package com.demo;

class LinkedNode {

	int data;
	LinkedNode next;
}

public class LinkedListCycle {

	public static void main(String[] args) {

		LinkedNode headStart = new LinkedNode();
		LinkedNode headStart1 = new LinkedNode();
		LinkedNode headStart2 = new LinkedNode();
		LinkedNode headStart3 = new LinkedNode();
		headStart.next = headStart1;
		headStart1.next = headStart2;
		headStart2.next = headStart3;
		//headStart3.next = headStart1;
		System.out.println(hasCycle(headStart));

	}

	// private static LinkedNode headNode;

	static boolean hasCycle(LinkedNode head) {

		if (head == null)
			return false;
		LinkedNode fast = head.next;
		LinkedNode slow = head;
		while (fast != null && fast.next != null && slow != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

}
