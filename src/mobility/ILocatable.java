package mobility;

/**
 * A interface that describes location of animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public interface ILocatable {

	/**
	 * Getter for location
	 * 
	 * @return point of location
	 */
	public Point getLocation();

	/**
	 * Setter for location (x,y)
	 * 
	 * @param p - point
	 * @return if succeeded
	 */
	public boolean setLocation(Point p);
}
