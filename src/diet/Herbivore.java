package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A class that describes animal Herbivore type which inherited from IDiet
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see IDiet
 *
 */
public class Herbivore implements IDiet  {

	/**
	 * Constructor for Herbivore
	 * 
	 */
	public Herbivore() {
	}
	
	/**
	 * Method that "check" if Herbivore animal can eat certain food
	 * 
	 * @param food
	 */
	@Override
	public boolean canEat(EFoodType food) {
		boolean isSuccess = false;
		if (food.equals(EFoodType.VEGETABLE))
			isSuccess = true;
		return isSuccess;
	}
	
	/**
	 * Method that simulates Herbivore eat
	 * 
	 * @param food 
	 * @param animal 
	 * @return gain weight
	 */
	@Override
	public double eat(Animal animal, IEdible food) {
		if(this.canEat(food.getFoodtype()))
		   return animal.getWeight() * 0.07;
		return 0;
	}
	
	/**
	 * return string that represent Herbivore
	 * 
	 * @return Herbivore string
	 */
	public String toString() {
		return "[Herbivore]";
	}

}


