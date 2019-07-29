package testing;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExampleWithWaitAndNotify
{
	public static void main(String args[]) {
		List<Integer> taskQueue = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
		
		Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
		
		Thread tProducer2 = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer2");
		
		Thread tProducer3 = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer3");
		
		
		tProducer.start();
		System.out.println("size in main 1 "+ taskQueue.size());
		tProducer2.start();
		System.out.println("size in main 2 "+ taskQueue.size());
		tConsumer.start();		
		System.out.println("size in main consumer"+ taskQueue.size());
		tProducer3.start();
		System.out.println("size in main 3"+ taskQueue.size());
	}   
}