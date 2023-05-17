package animals;

import diet.Herbivore;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes Giraffe which inherited from ChewAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class Giraffe extends ChewAnimal {
	private double neckLength;

	/**
	 * Constructor for Giraffe
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
	public Giraffe(String name, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(name, new Point(50, 0), xSpeed, ySpeed, color, size, img, zoopanel, con);
		this.setNeckLength(1.5);
		this.setDiet(new Herbivore());
	}
	
	public Giraffe(Giraffe g) {
		super(g);
		this.setNeckLength(g.getNeckLength());
	}

	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return new Giraffe(this);
	}

	/**
	 * Getter for food type
	 * 
	 * @return food type
	 */
	public double getNeckLength() {
		return neckLength;
	}

	/**
	 * Sound of Giraffe
	 * 
	 * @return String of Giraffe sound
	 */
	public void chew() {
	}

	/**
	 * Setter for Neck Length
	 * 
	 * @return if succeeded
	 */
	public boolean setNeckLength(double neckLength) {
		boolean isSuccess = false;
		if (neckLength >= 0.5 && neckLength <= 3) {
			isSuccess = true;
			this.neckLength = neckLength;
		}
		return isSuccess;
	}

	@Override
	public boolean equals(Object o) {

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Giraffe)) {
			return false;
		}

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		if (!super.equals(o))
			return false;

		// typecast o to Complex so that we can compare data members
		Giraffe g = (Giraffe) o;

		// Compare the data members and return accordingly
		return this.getNeckLength() == g.getNeckLength();
	}

	/**
	 * Returns "Giraffe" String
	 * 
	 */
	@Override
	public String getAnimalName() {
		return "Giraffe";
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	@Override
	public void setWeightBySize(int size) {
		this.setWeight(size * 2.2);
	}

}
