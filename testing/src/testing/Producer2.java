package testing;

import java.util.ArrayList;
import java.util.List;

public class Producer2 implements Runnable {

	List<Integer> mesgQ = new ArrayList<Integer>();
	int MAX_SIZE;

	public Producer2(List<Integer> mesgQ, int size) {
		this.mesgQ = mesgQ;
		this.MAX_SIZE = size;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {				
				produce(counter++);
			} catch (Exception e) {
				System.out.println("Error while producing item");
			}
		}
	}

	private void produce(int counter) throws InterruptedException {
		synchronized (mesgQ) {
			while (mesgQ.size() == MAX_SIZE) {
				System.out.println("Thread is waiting as Queue is full" + Thread.currentThread().getName());
				try {
					mesgQ.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("produced "+ counter +"\n");
			Thread.sleep(1000);
			mesgQ.add(counter);
			mesgQ.notifyAll();
		}
	}
}
