package decorator;

import animals.Animal;

/**
 * A class that paints animal in Red which inherited from PaintAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see PaintAnimal
 *
 */
public class RedPaintAnimal extends PaintAnimal {

	/**
	 * Constructor for red paint animal
	 * 
	 * @param animal - animal
	 */
	public RedPaintAnimal(Animal animal) {
		super(animal);
		this.changeColor();
	}

	/**
	 * change color method to red
	 * 
	 */
	@Override
	public void changeColor() {
		this.animal.setCol("Red");
		this.animal.loadImages(this.animal.getClass().getSimpleName().substring(0, 3).toLowerCase());
	}

}
