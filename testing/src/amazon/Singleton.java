package amazon;

public class Singleton {

	private volatile static  Singleton singletonObj = null;

	private Singleton() {

	}

	public static Singleton getInstance() {

		if (singletonObj == null) {
			synchronized (Singleton.class) {
				if (singletonObj == null)
					return new Singleton();
			}
		}
		return singletonObj;
	}
}
