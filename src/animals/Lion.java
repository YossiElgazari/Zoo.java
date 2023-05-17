package animals;

import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;
import diet.Carnivore;
import diet.Herbivore;

import java.util.Random;

/**
 * A class that describes Lion which inherited from RoarAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see RoarAnimal
 *
 */
public class Lion extends RoarAnimal {
	private int scarCount;

	/**
	 * Constructor for Lion
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
	public Lion(String name, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(name, new Point(20, 0), xSpeed, ySpeed, color, size, img, zoopanel, con);
		this.setDiet(new Carnivore());
		this.setScarCount(0);
	}

	public Lion(Lion l) {
		super(l);
		this.setScarCount(l.getScarCount());
	}

	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return new Lion(this);
	}

	/**
	 * Sound of Lion
	 * 
	 * @return String of Lion sound
	 */
	public void roar() {
	}

	/**
	 * Method that simulates Lion eat
	 * 
	 * @param e - food
	 * @return boolean - if eaten
	 */
	public boolean eat(IEdible e) {
		boolean isSuccess = false;
		if (super.eat(e)) {
			Random rnd = new Random();
			isSuccess = true;
			if (rnd.nextBoolean())
				this.setScarCount(this.getScarCount() + 1);
			return isSuccess;
		}
		return isSuccess;
	}

	/**
	 * Getter for food type
	 * 
	 * @return food type
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.NOTFOOD;
	}

	public int getScarCount() {
		return scarCount;
	}

	/**
	 * Setter for Scar Count
	 * 
	 * @return if succeeded
	 */
	public boolean setScarCount(int scarCount) {
		boolean isSuccess = false;
		if (scarCount > 0) {
			isSuccess = true;
			this.scarCount = scarCount;
		}
		return isSuccess;
	}

	@Override
	public boolean equals(Object o) {

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Lion)) {
			return false;
		}

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		if (!super.equals(o))
			return false;

		// typecast o to Complex so that we can compare data members
		Lion l = (Lion) o;

		// Compare the data members and return accordingly
		return this.getScarCount() == l.getScarCount();
	}

	/**
	 * return "Lion" String
	 * 
	 */
	@Override
	public String getAnimalName() {
		return "Lion";
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	@Override
	public void setWeightBySize(int size) {
		this.setWeight(size * 0.8);
	}

}
