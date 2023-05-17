package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
/**
 * A class that describes animal carnivore type which inherited from IDiet
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see IDiet
 *
 */
public class Carnivore implements IDiet {

	/**
	 * Constructor for carnivore
	 * 
	 */
	public Carnivore() {
	}

	/**
	 * Method that "check" if carnivore animal can eat certain food
	 */
	@Override
	public boolean canEat(EFoodType food) {
		boolean isSuccess = false;
		if (food.equals(EFoodType.MEAT))
			isSuccess = true;
		return isSuccess;
	}

	/**
	 * Method that simulates Carnivore eat
	 * 
	 * @param food
	 * @param animal
	 * @return gain weight
	 */
	@Override
	public double eat(Animal animal, IEdible food) {
		if (this.canEat(food.getFoodtype()))
			return animal.getWeight() * 0.1;
		return 0;
	}
	
	/**
	 * return string that represent Carnivore
	 * 
	 * @return Carnivore string
	 */
	public String toString() {
		return "[Carnivore]";
	}

}
