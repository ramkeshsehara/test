package testing;

class Demo {

	public void disp() {
		System.out.println("disp() method of parent class");
	}
	
	public void A() {
		System.out.println("xyzzzz");
	}
}

public class ABC extends Demo {

	public static void main(String args[]) {
		Demo obj = new ABC();
		obj.disp();
		obj.A();
	}

	public void disp() {
		System.out.println("disp() method of Child class");
	}
}
