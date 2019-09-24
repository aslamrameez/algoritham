package org.algoritham;

public class LinkedListQuestions {

	public static void main(String[] args) {
		Node head = new Node(85);
		head.right = new Node(15);
		head.right.right = new Node(4);
		head.right.right.right = new Node(20);

		print(reverseList(head));
	}

	private static void print(Node reverseList) {

		while (reverseList != null) {
			System.out.print(reverseList.data);
			reverseList = reverseList.right;
		}
		System.out.println();
	}

	private static Node reverseList(Node head) {

		Node current = head;
		Node prev = null;
		while (current != null) {

			Node next = current.right;
			current.right = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}
