package animals;

import diet.Herbivore;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes Elephant which inherited from ChewAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see ChewAnimal
 *
 */
public class Elephant extends ChewAnimal {
	private double trunkLength;

	/**
	 * Constructor for Elephant
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
	public Elephant(String name, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(name, new Point(50, 90), xSpeed, ySpeed, color, size, img, zoopanel, con);
		this.settrunkLength(1);
		this.setDiet(new Herbivore());
	}
	
	public Elephant(Elephant e) {
		super(e);
		this.settrunkLength(e.gettrunkLength());
	}

	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return new Elephant(this);
	}

	/**
	 * Sound of Elephant
	 * 
	 * @return String of Elephant sound
	 */
	public void chew() {

	}

	/**
	 * Getter for trunk length
	 * 
	 * @return trunk length
	 */
	public double gettrunkLength() {
		return trunkLength;
	}

	/**
	 * Setter for trunk length
	 * 
	 * @return if succeeded
	 */
	public boolean settrunkLength(double trunkLength) {
		boolean isSuccess = false;
		if (trunkLength >= 0.5 && trunkLength <= 3) {
			isSuccess = true;
			this.trunkLength = trunkLength;
		}
		return isSuccess;
	}

	@Override
	public boolean equals(Object o) {

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Elephant)) {
			return false;
		}

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		if (!super.equals(o))
			return false;

		// typecast o to Complex so that we can compare data members
		Elephant e = (Elephant) o;

		// Compare the data members and return accordingly
		return this.gettrunkLength() == e.gettrunkLength();
	}

	/**
	 * Returns "Elephant" String
	 * 
	 */
	@Override
	public String getAnimalName() {
		return "Elephant";
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	@Override
	public void setWeightBySize(int size) {
		this.setWeight(size * 10);

	}
}
