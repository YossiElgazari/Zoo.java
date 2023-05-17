package memento;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import animals.Animal;

/**
 * class that describes Zoo State Memento and holds the needed attributes
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class ZooStateMemento {
	private ArrayList<Animal> animals;
	private Color background;
	private String food;
	private BufferedImage img;

	/**
	 * Package protected constructor for ZooStateMemento
	 * 
	 * @param animals - animals
	 * @param bg      - background
	 * @param f       - food
	 * @param img     - string img
	 */
	ZooStateMemento(ArrayList<Animal> animals, Color bg, String f, BufferedImage img) {
		this.animals = new ArrayList<Animal>(animals.size());
		for (Animal animal : animals) {
			try {
				this.animals.add((Animal) animal.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println("Cant copy " + animal.toString());
			}
		}
		this.background = bg;
		this.food = f;
		this.img = img;
	}

	/**
	 * Getter for food
	 * 
	 * @return string food
	 */
	public String getFood() {
		return food;
	}

	/**
	 * getter for bg
	 * 
	 * @return bg string
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * getter for animals
	 * 
	 * @return animal list
	 */
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	/**
	 * getter for img
	 * 
	 * @return img
	 */
	public BufferedImage getImg() {
		return img;
	}
}
