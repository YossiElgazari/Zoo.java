package factory;

import animals.Animal;
import animals.Bear;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes factory that "produces" omnivore animal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class OmnivoreFactory implements AnimalFactory {

	/**
	 * method that creates omnivore animal
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
		if ("Bear".equals(animal)) {
			return new Bear(name, xSpeed, ySpeed, color, size, img, zoopanel, con);
		}
		return null;
	}
}
