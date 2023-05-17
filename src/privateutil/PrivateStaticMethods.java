package privateutil;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import mobility.Mobile;

/**
 * A class of static methods
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see Mobile
 *
 */
public class PrivateStaticMethods {

	/**
	 * Return the instance of animal
	 * 
	 * @param animal
	 * @return instance
	 */
	public static Animal ReturnInstance(Object animal) {
		if (animal instanceof Lion)
			return (Lion) animal;
		if (animal instanceof Bear)
			return (Bear) animal;
		if (animal instanceof Elephant)
			return (Elephant) animal;
		if (animal instanceof Giraffe)
			return (Giraffe) animal;
		if (animal instanceof Turtle)
			return (Turtle) animal;
		return null;
	}

	/**
	 * 
	 * @param animals
	 * @param index
	 * @return
	 */
	public static Animal[] CreateArrayWithout(Animal[] animals, int index) {
		Animal[] temp = new Animal[animals.length - 1];
		int j = 0;
		for (int i = 0; i < animals.length; i++) {
			if (i != index) {
				temp[j] = animals[i];
				j++;
			}
		}
		return temp;
	}

	/**
	 * 
	 * @param animal
	 * @return
	 */
	public static boolean CheckIfExist(String animal) {
		if (animal.equals("Lion"))
			return true;
		if (animal.equals("Bear"))
			return true;
		if (animal.equals("Elephant"))
			return true;
		if (animal.equals("Giraffe"))
			return true;
		if (animal.equals("Turtle"))
			return true;
		return false;
	}

	public static void printMy() {
		System.out.println("Select from the list the animal you wish: ");
		System.out.println("1.Lion");
		System.out.println("2.Bear");
		System.out.println("3.Elephant");
		System.out.println("4.Giraffe");
		System.out.println("5.Turtle");
		System.out.println("Which animal? (Exact word): ");
	}

}
