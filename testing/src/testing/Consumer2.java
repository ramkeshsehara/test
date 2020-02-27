package testing;

import java.util.List;

public class Consumer2 implements Runnable {

	private List<Integer> mesgQ;

	public Consumer2(List<Integer> sharedQ) {
		mesgQ = sharedQ;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (Exception e) {

			}
		}

	}

	private void consume() throws InterruptedException {
		synchronized (mesgQ) {
			while (mesgQ.isEmpty()) {
				System.out.println("Messaging Queue is Empty unable to consume data" + Thread.currentThread().getName());
				try {
					mesgQ.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Thread.sleep(600);
			System.out.println(mesgQ.remove(0));
			mesgQ.notifyAll();
		}

	}

}
