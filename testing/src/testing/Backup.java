//package testing;
//
//
//
//public class Backup {
//
//	public static void main(String args[]) {
//		Node head = null;
//		Algo obj = new Algo();
//
////		obj.insertElement(head, 1);
////		obj.insertElement(head, 3);
////		obj.insertElement(head, 30);
////		obj.insertElement(head, 90);
////		obj.insertElement(head, 120);
////		obj.insertElement(head, 240);
////		obj.insertElement(head, 511);
//
//		// for(int i=1; i<=10; i++) {
//		// head=obj.insertElement(head, i);
//		// }
//
////		Node head2 = null;
////		obj.insertElement(head2, 0);
////		obj.insertElement(head2, 3);
////		obj.insertElement(head2, 12);
////		obj.insertElement(head2, 32);
////		obj.insertElement(head2, 90);
////		obj.insertElement(head2, 125);
////		obj.insertElement(head2, 240);
////		obj.insertElement(head2, 249);
////
////		Node head3 = null;
////		head3 = obj.sumLinkList(head, head2);
//
//		// for(int i=100; i<=110; i++) {
//		// head2=obj.insertElement(head2, i);
//		// }
//
//		// obj.printList(head);
//		// head=obj.reverseList(head);
//		// head=obj.reverseChunks(head,3);
//		// obj.printList(head);
//
//	}
//
//	private Node sumLinkList(Node head, Node head2) {
//		Node maxList = null;
//		Node current1 = head;
//		Node current2 = head2;
//		
//		if (current1 == null)
//			return head2;
//		if (current2 == null)
//			return head;
//		
//		int sum1 = 0, sum2 = 0;
//		Node interm = null;
//		while (current1 != null && current2 != null) {
//
//			if (current1.data < current2.data) {
//				current1 = current1.next;
//				sum1 += current1.data;
//			} else if (current1.data > current2.data) {
//				current2 = current2.next;
//				sum2 += current2.data;
//			} else {
//				if (maxList == null) {
//					if (sum1 > sum2) {
//						maxList = head;
//						interm = current2.next;
//					} else {
//						maxList = head2;
//						interm = current1.next;
//					}
//					sum1 = 0;
//					sum2 = 0;
//				} else {
//
//				}
//			}
//		}
//
//		return null;
//	}
//
//	private Node reverseChunks(Node head, int i) {
//		Node current = head;
//		Node prev = null;
//		Node next;
//		int count = 0;
//		while (count < i && current != null) {
//			next = current.next;
//			current.next = prev;
//			prev = current;
//			current = next;
//			count++;
//		}
//		if (head != null)
//			head.next = reverseChunks(current, i);
//
//		return prev;
//
//	}
//
//	private Node reverseList(Node head) {
//		Node current = head;
//		Node prev = null;
//		Node next;
//		while (current != null) {
//			next = current.next;
//			current.next = prev;
//			prev = current;
//			current = next;
//		}
//		return prev;
//	}
//
//	private Node insertElement(Node head, int i) {
//		if (head == null) {
//			head = new Node(i);
//			return head;
//		} else {
//			Node current = head;
//			Node last = new Node(i);
//			while (current.next != null) {
//				current = current.next;
//			}
//			current.next = last;
//			return head;
//		}
//	}
//
//	private void printList(Node head) {
//		Node current = head;
//		while (current != null) {
//			System.out.print(current.data + " ");
//			current = current.next;
//		}
//	}
//}
