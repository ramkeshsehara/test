package testing;

import java.util.ArrayList;
import java.util.List;

public class PCExample {

	public static void main(String args[]) {
		List<Integer> jobQ = new ArrayList<Integer>();
		int max=10;
		Producer2 obj1=new Producer2(jobQ,max);
		Consumer2 obj2 =new Consumer2(jobQ);
		
		Producer2 obj3=new Producer2(jobQ,max);
		Consumer2 obj4 =new Consumer2(jobQ);
		
		Thread p1= new Thread (obj1, "producer1");
		Thread c1 = new Thread (obj2,"Consumer1");
		
		Thread p2= new Thread (obj1, "producer2");
		Thread c2 = new Thread (obj2,"Consumer2");
		
		p1.start();
		c1.start();
		p2.start();
		c2.start();		
	}
}
