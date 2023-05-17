package decorator;

import animals.Animal;

/**
 * An abstract concrete class that holds animal to paint which implements ChangeColor
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public abstract class PaintAnimal implements ChangeColor {
	protected Animal animal;
	
	/**
	 * Constructor for paint animal
	 * 
	 * @param animal - animal
	 */
	public PaintAnimal(Animal animal) {
		this.animal = animal;
	}
	
}
