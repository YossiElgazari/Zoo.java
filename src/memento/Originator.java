package memento;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import animals.Animal;

/**
 * Class that saves ZooStateMemento
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class Originator {
	private ArrayList<Animal> animals;
	private Color background;
	private String food;
	private BufferedImage img;

	/**
	 * Getter for animals
	 *  
	 * @return animals list
	 */
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	/**
	 * Setter for animals
	 *  
	 * @param animals - animals
	 */
	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * getter for background
	 * 
	 * @return bg
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * Setter for background
	 * 
	 * @param background - bg
	 */
	public void setBackground(Color background) {
		this.background = background;
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
	 * Setter for food
	 * 
	 * @param food - food
	 */
	public void setFood(String food) {
		this.food = food;
	}

	/**
	 * method that saves the exact moment on ZooPanel
	 * 
	 * @return
	 */
	public ZooStateMemento saveState() {
		return new ZooStateMemento(animals, background, food, img);
	}

	/**
	 * restores the state by stack order
	 * 
	 * @param state
	 */
	public void restoreState(ZooStateMemento state) {
		setAnimals(state.getAnimals());
		setBackground(state.getBackground());
		setFood(state.getFood());
		setImg(state.getImg());
	}

	/**
	 * Getter for img
	 * 
	 * @return img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * Setter for img
	 * 
	 * @param img - img
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
