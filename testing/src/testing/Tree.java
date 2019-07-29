package testing;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Value {
	int min, max;
}

public class Tree {

	public static void main(String args[]) {
		Tree t = new Tree();
		Node root = t.createTree();
		t.topView(root);
	}

	private void topView(Node root) {
		Value v = new Value();
		minMax(root, v, 0);
		Map<Integer, Vector<Integer>> map = new TreeMap<Integer, Vector<Integer>>();

		fillMap(root, map, 0);

		map.forEach((k, va) -> {
			va.forEach(ve -> {
				System.out.print(ve + " ");
			});
			System.out.println();
		});

	}

	private void fillMap(Node root, Map<Integer, Vector<Integer>> map, int hd) {
		if (root != null) {
			Vector<Integer> v;
			if (map.containsKey(hd)) {
				v = map.get(hd);
				v.add(root.data);
				map.put(hd, v);
			} else {
				v = new Vector<Integer>();
				v.add(root.data);
				map.put(hd, v);
			}
			fillMap(root.left, map, hd - 1);
			fillMap(root.right, map, hd + 1);
		}
	}

	private void minMax(Node root, Value v, int current) {

		if (root != null) {
			if (current < v.min)
				v.min = current;
			if (current > v.max)
				v.max = current;
			minMax(root.left, v, current - 1);
			minMax(root.right, v, current + 1);
		}

	}

	static int MB = 0;

	private void leftView(Node root) {
		leftViewUtil(root, 1);
	}

	private void leftViewUtil(Node root, int CB) {
		if (root != null) {
			if (CB > MB) {
				MB = CB;
				System.out.println(root.data);
			}
			leftViewUtil(root.left, CB + 1);
			leftViewUtil(root.right, CB + 1);
		}
	}

	private void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}

	private void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
			while (!q.isEmpty()) {
				int count = q.size();
				while (count > 0) {
					Node temp = q.poll();
					System.out.print(temp.data + " ");
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
					count--;
				}
				System.out.println("\n");

			}
		}

	}

	private Node createTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}
}
