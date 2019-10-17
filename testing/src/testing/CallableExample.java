package testing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(4);		
		List<Future<Integer>> resultList = new ArrayList<>();
		
		for(int i=8; i<18; i++) {			
			FactorialCalculator fc = new FactorialCalculator(i);
			Future<Integer> value= executor.submit(fc);
			resultList.add(value);
		}

		for(Future<Integer> fcValue: resultList) {
			try {
				System.out.println("Future result is :" +fcValue.get() + "and task is done" + fcValue.isDone() );
			} catch (Exception e) {
			}
			executor.shutdown();
		}
		
		List<LinkedList<Integer>> vertex = new ArrayList<LinkedList<Integer>>();
		
		
	}

}
