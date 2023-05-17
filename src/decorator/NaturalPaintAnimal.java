package decorator;

import animals.Animal;

/**
 * A class that paints animal in Natural which inherited from PaintAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see PaintAnimal
 *
 */
public class NaturalPaintAnimal extends PaintAnimal {

	/**
	 * Constructor for NaturalPaintAnimal
	 * 
	 * @param animal - animal
	 */
	public NaturalPaintAnimal(Animal animal) {
		super(animal);
		this.changeColor();
	}

	/**
	 * change color method to natural
	 * 
	 */
	@Override
	public void changeColor() {
		this.animal.setCol("Natural");
		this.animal.loadImages(this.animal.getClass().getSimpleName().substring(0, 3).toLowerCase());
	}
}