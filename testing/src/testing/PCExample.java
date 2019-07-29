package testing;

import java.util.ArrayList;
import java.util.List;

public class PCExample {

	public static void main(String args[]) {
		List<Integer> jobQ = new ArrayList<Integer>();
		int max=5;
		Thread p2= new Thread (new Producer2(jobQ,max), "producer2");
		Thread c2 = new Thread (new Consumer2(jobQ),"Consumer2");
		
		p2.start();
		c2.start();		
	}
}
