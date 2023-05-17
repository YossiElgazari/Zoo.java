package decorator;

import animals.Animal;

/**
 * A class that paints animal in blue which inherited from PaintAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see PaintAnimal
 *
 */
public class BluePaintAnimal extends PaintAnimal {

	/**
	 * Constructor for BluePaintAnimal
	 * 
	 * @param animal - animal
	 */
	public BluePaintAnimal(Animal animal) {
		super(animal);
		this.changeColor();
	}

	/**
	 * change color method to blue
	 * 
	 */
	@Override
	public void changeColor() {
		this.animal.setCol("Blue");
		this.animal.loadImages(this.animal.getClass().getSimpleName().substring(0, 3).toLowerCase());
	}

}
