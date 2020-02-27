package testing;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer>{

	private Integer number;
	public FactorialCalculator(Integer number) {
		this.number=number;
	}
	
	@Override
	public Integer call() throws Exception {
		int result=1;
		for(int i=1; i<number; i++) {
			result=result*i;
			TimeUnit.MILLISECONDS.sleep(2000);
		}
		return result;
	}
	
	
}
