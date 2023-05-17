package factory;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Turtle;
import graphics.ZooPanel;
import observer.Controller;

/**
 * A class that describes factory that "produces" Herbivore animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class HerbivoreFactory implements AnimalFactory {

	/**
	 * method that creates Herbivore animal
	 * 
	 * @param animal   - animal
	 * @param name     - name
	 * @param xSpeed   - horizontal speed
	 * @param ySpeed   - vertical speed
	 * @param color    - color
	 * @param size     - size
	 * @param img      - img sentence
	 * @param zoopanel - zoo panel
	 * @param con      - controller
	 */
	@Override
	public Animal createAnimal(String animal, String name, int xSpeed, int ySpeed, String color, int size, String img,
			ZooPanel zoopanel, Controller con) {
		if ("Turtle".equals(animal)) {
			return new Turtle(name, xSpeed, ySpeed, color, size, img, zoopanel, con);
		} else if ("Giraffe".equals(animal)) {
			return new Giraffe(name, xSpeed, ySpeed, color, size, img, zoopanel, con);
		} else if ("Elephant".equals(animal)) {
			return new Elephant(name, xSpeed, ySpeed, color, size, img, zoopanel, con);
		}
		return null;
	}
}
