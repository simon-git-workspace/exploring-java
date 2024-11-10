import java.util.Objects;

public class SignletonMain {
	public static void main(String[] args) {
		// Eager Initialization

		// System.out.println(EagerInitializationSingleton.getInstance());
		// System.out.println(EagerInitializationSingleton.getInstance());

		// Static Block Initialization
		// System.out.println(StaticBlockSingleton.getInstance());
		// System.out.println(StaticBlockSingleton.getInstance());
		
		// LazyInitialization
		// System.out.println(LazyInitialization.getInstance());
		// System.out.println(LazyInitialization.getInstance());
		
		// LazyInitializationThreadSafe
		// System.out.println(LazyInitializationThreadSafe.getInstance());
		// System.out.println(LazyInitializationThreadSafe.getInstance());

	}
}

class EagerInitializationSingleton {

	private static final EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();

	private EagerInitializationSingleton() {
	}

	public static EagerInitializationSingleton getInstance() {
		return INSTANCE;
	}
}

class StaticBlockSingleton {
	private static StaticBlockSingleton INSTANCE;

	static {
		try {
			INSTANCE = new StaticBlockSingleton();
		} catch (Exception ex) {
			throw new RuntimeException(
					"Error during singleton object creation :: Error Message(" + ex.getMessage() + ")");
		}
	}

	private StaticBlockSingleton() {
	}

	public static StaticBlockSingleton getInstance() {
		return INSTANCE;
	}
}

class LazyInitialization {
	private static LazyInitialization INSTANCE;
	
	private LazyInitialization() {}
	
	public static LazyInitialization getInstance() {
		if(Objects.isNull(INSTANCE)) {
			INSTANCE = new LazyInitialization();
		}
		return INSTANCE;
	}
}

class LazyInitializationThreadSafe {
	private static LazyInitializationThreadSafe INSTANCE;
	
	private LazyInitializationThreadSafe() {}
	
	public static LazyInitializationThreadSafe getInstance() {
		if(Objects.isNull(INSTANCE)) {
			synchronized (LazyInitializationThreadSafe.class) {
				if(Objects.isNull(INSTANCE)) {
					INSTANCE = new LazyInitializationThreadSafe();
				}
			}
		}
		return INSTANCE;
	}
}

class BillPughSingleton {
	private BillPughSingleton() {}
	
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}