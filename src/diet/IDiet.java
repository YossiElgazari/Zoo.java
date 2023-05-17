package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A interface that describes diet of animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public interface IDiet {

	/**
	 * Method that "check" if certain type of animal can eat certain food
	 */
	public boolean canEat(EFoodType food);

	/**
	 * Method that simulates Herbivore eat
	 * 
	 * @param food
	 * @param animal
	 */
	public double eat(Animal animal, IEdible food);
}
