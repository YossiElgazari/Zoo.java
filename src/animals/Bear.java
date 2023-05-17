package animals;

import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes Bear which inherited from RoarAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Shai Matzliach
 * @author Yossi Elgazari
 * @see RoarAnimal
 *
 */
public class Bear extends RoarAnimal {
	private String furColor;

	/**
	 * Constructor for Bear
	 * 
	 * @param name     - name
	 * @param p        - Location
	 * @param xSpeed   - horizontal speed
	 * @param ySpeed   - vertical speed
	 * @param color    - color of animal
	 * @param size     - size of animal
	 * @param img      - img url
	 * @param zoopanel - panel
	 */
	public Bear(String name, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(name, new Point(100, 5), xSpeed, ySpeed, color, size, img, zoopanel, con);
		this.setFurColor("GRAY");
		this.setDiet(new Omnivore());
	}

	/**
	 * Copy Constructor for bear
	 * 
	 * @param b - bear
	 */
	public Bear(Bear b) {
		super(b);
		this.setFurColor(b.getFurColor());
	}

	/**
	 * method to clone bear
	 */
	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return new Bear(this);
	}

	/**
	 * Getter for fur color
	 * 
	 * @return fur color
	 */
	public String getFurColor() {
		return furColor;
	}

	/**
	 * Setter for fur color
	 * 
	 * @return if succeeded
	 */
	public boolean setFurColor(String furColor) {
		boolean isSuccess = false;
		if (furColor.equals("BLACK") || furColor.equals("GRAY") || furColor.equals("WHITE")) {
			this.furColor = furColor;
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean equals(Object o) {

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Bear)) {
			return false;
		}

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		if (!super.equals(o))
			return false;

		// typecast o to Complex so that we can compare data members
		Bear b = (Bear) o;

		// Compare the data members and return accordingly
		return this.getFurColor().equals(b.getFurColor());
	}

	/**
	 * Sound of bear
	 * 
	 * @return String of bear sound
	 */
	@Override
	public void roar() {

	}

	/**
	 * Returns "Bear" String
	 */
	@Override
	public String getAnimalName() {
		return "Bear";
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	@Override
	public void setWeightBySize(int size) {
		this.setWeight(size * 1.5);
	}

}
