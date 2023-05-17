package mobility;

/**
 * A class that describes Line with the formula y = m*x + b
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari & Shai Matzliach
 * @see Mobile
 *
 */
public class Line {

	Point p;
	double b;
	double m;

	/**
	 * Constructor for line
	 * 
	 * @param p       - point
	 * @param incline - incline
	 */
	public Line(Point p, double incline) {
		this.b = calcB(p, incline);
		this.m = incline;
		this.p = p;
	}

	/**
	 * functions that calculates incline using 2 points
	 * 
	 * @param p1 - point 1
	 * @param p2 - point 2
	 * @return incline
	 */
	public static double calcIncline(Point p1, Point p2) {
		double y = p2.getY() - p1.getY();
		double x = p2.getX() - p1.getX();
		double incline = y / x;
		if (!(incline < Double.POSITIVE_INFINITY && incline > Double.NEGATIVE_INFINITY))
			incline = 0;
		return incline;
	}

	/**
	 * functions that calculates the variable B
	 * 
	 * @param p       - point
	 * @param incline - incline
	 * @return B
	 */
	public double calcB(Point p, double incline) {
		return p.getY() - incline * p.getX();
	}

	public int returnY(int x) {
		return (int) (this.m * x + b);
	}

	/**
	 * returns statement of the form y = m*x + b
	 * 
	 */
	@Override
	public String toString() {
		if (this.b < 0)
			return "y = " + this.m + "x" + " " + this.b;
		return "y = " + this.m + "x" + " +" + this.b;
	}

}
