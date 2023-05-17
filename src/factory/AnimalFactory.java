package factory;

import animals.Animal;
import graphics.ZooPanel;
import observer.Controller;

/**
 * An Interface that implements Animal Factory
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public interface AnimalFactory {
	public Animal createAnimal(String animal, String name, int xSpeed, int ySpeed, String color, int size, String img,
			ZooPanel zoopanel, Controller controller);
}
