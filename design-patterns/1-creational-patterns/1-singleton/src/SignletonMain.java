
public class SignletonMain {
	public static void main(String[] args) {
		// Eager Initialization

		// System.out.println(EagerInitializationSingleton.getInstance());
		// System.out.println(EagerInitializationSingleton.getInstance());

		// Static Block Initialization
		 System.out.println(EagerInitializationSingleton.getInstance());
		 System.out.println(EagerInitializationSingleton.getInstance());

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