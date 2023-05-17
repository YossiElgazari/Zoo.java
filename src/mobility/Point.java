package mobility;

/**
 * A class that represent Point (x,y) of animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see ILocatable
 *
 */
public class Point implements Cloneable {

	private int x;
	private int y;

	static final int MAXX = 800; // Constant Y axis max
	static final int MAXY = 600; // Constant X axis max
	static final int MIN = -1; // Constant X,Y axis min

	/**
	 * Constructor for point
	 * 
	 * @param x - x axis
	 * @param y - y axis
	 */
	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Getter for x
	 * 
	 * @return x axis
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Getter for y
	 * 
	 * @return y axis
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Method that check if point is in boundaries
	 * 
	 * @param newLocation - point
	 * @return if is in boundaries
	 */
	public static boolean cheackBounderies(Point newLocation) {
		return (newLocation.getX() <= MAXX) && (newLocation.getX() >= MIN) && (newLocation.getY() <= MAXY)
				&& (newLocation.getY() >= MIN) || true;
	}

	@Override
	public String toString() {
		return this.getX() + " , " + this.getY();
	}

}
