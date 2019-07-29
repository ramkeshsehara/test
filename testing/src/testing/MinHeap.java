package testing;

public class MinHeap {

	private int[] heap;
	private int size;
	private int maxSize;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = -1;
		heap = new int[maxSize];

	}

	private int leftChild(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return 2 * index + 2;
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private void swap(int fpos, int spos) {
		int temp = heap[spos];
		heap[spos] = heap[fpos];
		heap[fpos] = temp;
	}

	private void heapifyUp() {
		int curr = size;
		while (curr != 0 && heap[curr] < heap[parent(curr)]) {
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}

	public void insert(int element) {
		if (size < maxSize - 1) {
			size++;
			heap[size] = element;
			heapifyUp();
		}
	}

	public int peek() {
		if (size > -1)
			return heap[0];
		else
			return Integer.MIN_VALUE;
	}

	private Boolean isLeaf(int index) {
		int l = leftChild(index);
		int r = rightChild(index);
		if (l >= 0 && r < maxSize)
			return true;
		return false;
	}

	private void heapifyDown(int pos) {
		if (!isLeaf(pos)) {
              if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
            	  if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
            		  swap(leftChild(pos),pos);
            		  heapifyDown(leftChild(pos));
            	  }
            	  else {
            		  swap(rightChild(pos),pos);
            		  heapifyDown(rightChild(pos));
            	  }
              }
		}
	}

	public int extractMin() {
		if (size > -1) {
			int val = heap[0];
			heap[0] = heap[size];
			size--;
			heapifyDown(0);
			return val;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String args[]) {
		int maxSize = 10;
		MinHeap mh = new MinHeap(maxSize);
		mh.insert(10);
		mh.insert(12);
		mh.insert(6);
		System.out.println(mh.peek());
		int emin = mh.extractMin();
		System.out.println("Extracted min value : " + emin);
		
		emin = mh.extractMin();
		System.out.println("Extracted min value : " + emin);
	}
}
