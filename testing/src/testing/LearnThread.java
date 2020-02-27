package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class LearnThread{

	
	
	static ThreadPoolExecutor executor;
	
	public static void main (String agrs[]) {
		LearnThread obj= new LearnThread();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.print("test");
			}
		}).start();
		
		List<Future<Boolean>> result = new ArrayList<Future<Boolean>>();
		
		result.add(executor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        }));
	     
		new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		}).start();
		
		
		executor.submit(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return null;
			}		
		});
		
		
		
	}
}


