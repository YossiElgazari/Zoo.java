package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A class that describes animal Omnivore type which inherited from IDiet
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see IDiet
 *
 */
public class Omnivore implements IDiet {

	private Carnivore c;
	private Herbivore h;

	/**
	 * Constructor for Omnivore
	 * 
	 */
	public Omnivore() {
		this.c = new Carnivore();
		this.h = new Herbivore();
	}

	/**
	 * Method that "check" if Omnivore animal can eat certain food
	 */
	@Override
	public boolean canEat(EFoodType food) {
		boolean isSuccess = false;
		if (h.canEat(food) || c.canEat(food))
			isSuccess = true;
		return isSuccess;
	}

	/**
	 * Method that simulates Omnivore eat
	 * 
	 * @param food
	 * @param animal
	 * @return gain weight
	 */
	@Override
	public double eat(Animal animal, IEdible food) {
		if (this.canEat(food.getFoodtype())) {
			if (h.canEat(food.getFoodtype()))
				return h.eat(animal, food);
			if (c.canEat(food.getFoodtype()))
				return c.eat(animal, food);
		}
		return 0;
	}

	/**
	 * return string that represent Omnivore
	 * 
	 * @return Omnivore string
	 */
	public String toString() {
		return "[Omnivore]";
	}
}
