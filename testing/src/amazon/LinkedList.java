package amazon;

class Node {
	int data;
	Node next;

	Node(int value) {
		this.data = value;
		next = null;
	}
}

public class LinkedList {

	private void printList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static void main(String args[]) {

		LinkedList list = new LinkedList();

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		list.printList(head);
		head=list.reverseList(head, 3);
		list.printList(head);

	}

	private Node reverseList(Node head, int k) {
		
		Node prev = null, next = null, current = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
