package plants;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
	private static Cabbage cabbageeInstance = null;

	private Cabbage() {
	}

	public static Cabbage getInstance() {
		if (cabbageeInstance == null)
			cabbageeInstance = new Cabbage();
		return cabbageeInstance;
	}

}
