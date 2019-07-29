package testing;

//import java.util.Hashtable;
//
//class Node {
//	int data;
//	Node next;
//
//	Node(int data) {
//		this.data = data;
//		next = null;
//	}
//}
//
//public class Linklist {
//
//	public static void main(String args[]) {
//		Node head = null;
//		Linklist obj = new Linklist();
//
//		for (int i = 1; i <= 5; i++) {
//			head = obj.insertElement(head, i);
//		}
//		
//		for (int i = 5; i>1; i--) {
//			head = obj.insertElement(head, i);
//		}
//		
//		for (int i = 5; i>1; i--) {
//			head = obj.insertElement(head, i);
//		}
//		
//		obj.removeUnsortedDuplicate(head);
//		obj.printList(head);
//		
//	}
//
//	private void removeUnsortedDuplicate(Node head) {
//		Node current=head;
//		Node prev=head;		
//		Hashtable<Integer,Integer> values = new Hashtable<>();
//		while(current!=null && current.next!=null) {
//			if(values.containsKey(current.data)) {
//				prev.next=current.next.next;
//			}else {
//				values.put(current.data, 1);
//				prev=current;
//			}	
//			current=current.next;
//		}
//	}
//
//	private void removeDuplicate(Node head) {
//		Node current=head;
//		while(current.next!=null) {
//			if(current.next.data==current.data) {
//				current.next=current.next.next;
//			}
//			else current=current.next;
//		}
//		
//	}
//
//	private Boolean isPalindrome(Node head) {
//		if (head == null)
//			return true;
//		int count = counts(head);
//		Node slow = head;
//		Node fast = head;
//		Node prev = null;
//		Boolean result = true;
//		if (count % 2 == 1) {
//			while (fast != null && fast.next != null) {
//				slow = slow.next;
//				fast = fast.next.next;
//			}
//			slow.next = reverseList(slow.next);
//			result = compareList(head, slow.next);
//			slow.next = reverseList(slow.next);
//		} else {
//			int mid = count / 2;
//			int sc = 0;
//			Node current = head;
//			while (sc != mid) {
//				sc++;
//				prev = current;
//				current = current.next;
//			}
//			prev.next = reverseList(current);
//			result = compareList(head, prev.next);
//			prev.next = reverseList(current);
//		}
//		return result;
//	}
//
//	private Boolean compareList(Node head, Node next) {
//
//		Node current1 = head;
//		Node current2 = next;
//		while (current1 != null && current2 != null) {
//			if (current1.data != current2.data)
//				return false;
//			current1 = current1.next;
//			current2 = current2.next;
//		}
//		return true;
//	}
//
//	private int counts(Node head) {
//		Node current = head;
//		int count = 0;
//		while (current != null) {
//			count++;
//			current = current.next;
//		}
//		return count;
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
