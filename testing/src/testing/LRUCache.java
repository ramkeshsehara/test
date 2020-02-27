package testing;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {

	static Deque<Integer> dq;
	static HashSet<Integer> map;
	int cSize;

	public LRUCache(int size) {
		dq = new LinkedList<Integer>();
		map = new HashSet<>();
		cSize = size;
	}

	public void insert(int key) {
		if (map.contains(key)) {
			int index = 0, i = 0;
			for (int e : dq) {
				if (e == key) {
					index = i;
					break;
				}
				i++;
			}
			dq.remove(index);
		} else {
			if (dq.size() == cSize) {
				int last = dq.removeLast();
				map.remove(last);
			}
		}

		dq.push(key);
		map.add(key);
	}

	public void display() {
		for (int e : dq) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		LRUCache ca = new LRUCache(4);
		ca.insert(1);
		ca.insert(2);
		ca.insert(3);
		ca.insert(1);
		ca.insert(4);
		ca.insert(5);
		ca.display();
	}
}

