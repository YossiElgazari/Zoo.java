package animals;

import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes RoarAnimal which inherited from Animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see Animal
 *
 */
public abstract class RoarAnimal extends Animal {

	/**
	 * Constructor from RoarAnimal
	 * 
	 * @param name     - name
	 * @param p        - Location
	 * @param xSpeed   - horizontal speed
	 * @param ySpeed   - vertical speed
	 * @param color    - color of animal
	 * @param size     - size of animal
	 * @param img      - img url
	 * @param zoopanel - panel
	 * @param con 
	 */
	public RoarAnimal(String name, Point p, int xSpeed, int ySpeed, String color, int size, String img,
			ZooPanel zoopanel, Controller con) {
		super(name, p, xSpeed, ySpeed, color, size, img, zoopanel,con);
	}
	
	/**
	 * copy constructor for roar animal
	 * 
	 * @param c - chew animal
	 */
	public RoarAnimal(RoarAnimal r) {
		super(r);
	}

	/**
	 * Method that simulates chew animal sound
	 * 
	 */
	public void makeSound() {
		this.roar();
	}

	/**
	 * Abstract method that simulates chew of animal
	 * 
	 */
	public abstract void roar();

}
