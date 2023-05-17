package mobility;

/**
 * A class that describes Mobility of animal which inherited from ILocatable
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see ILocatable
 *
 */
public abstract class Mobile implements ILocatable {

	private Point location;
	private double totalDistance; // > 0

	/**
	 * Constructor for Mobile
	 * 
	 * @param p - point
	 */
	public Mobile(Point p) {
		this.location = p;
		this.setTotalDistance(0);

	}

	/**
	 * Method that adds distance
	 * 
	 * @param d - distance
	 */
	public void addTotalDistance(double d) {
		this.setTotalDistance(this.getTotalDistance() + d);
	}

	/**
	 * Method that calculate distance using distance formula
	 * 
	 * @param p - point
	 * @return distance
	 */
	public double calcDistance(Point p) {
		double powX = Math.pow(p.getX() - location.getX(), 2);
		double powY = Math.pow(p.getY() - location.getY(), 2);
		return Math.sqrt(powX + powY);
	}

	/**
	 * Method that simulates Animal movement to certain point
	 * 
	 * @param p - point
	 * @return distance traveled
	 */
	public double move(Point p) {
		if (Point.cheackBounderies(p)) {
			double distance = calcDistance(p);
			this.setLocation(p);
			this.setTotalDistance(this.getTotalDistance() + distance);
			return distance;
		}
		return 0;
	}

	/**
	 * Getter for location
	 * 
	 * @return point
	 */
	public Point getLocation() {
		return this.location;
	}

	/**
	 * Setter for location
	 * 
	 * @param p - point
	 * @return if succeeded
	 */
	public boolean setLocation(Point p) {
		boolean isok = p != null;
		if (isok)
			this.location = new Point(p.getX(), p.getY());
		return isok;
	}

	/**
	 * Getter for total distance traveled
	 * 
	 * @return distance traveled
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	/**
	 * Setter for total distance
	 * 
	 * @param totalDistance
	 * @return if succeeded
	 */
	public boolean setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
		return true;
	}

}
