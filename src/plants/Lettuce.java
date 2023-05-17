package plants;



/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	private static Lettuce lettuceInstance = null;
	
	private Lettuce() {
	}
	
	public static Lettuce getInstance() {
		if (lettuceInstance == null)
			lettuceInstance = new Lettuce();
		return lettuceInstance;
	}
	
}
