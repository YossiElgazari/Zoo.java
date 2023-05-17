package animals;

import diet.Carnivore;
import diet.Herbivore;
import graphics.ZooPanel;
import mobility.Point;
import observer.Controller;

/**
 * A class that describes Turtle which inherited from ChewAnimal
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see ChewAnimal
 */
public class Turtle extends ChewAnimal {

	private int Age;

	/**
	 * Constructor for Turtle
	 * 
	 * @param name     - name
	 * @param p        - Location
	 * @param xSpeed   - horizontal speed
	 * @param ySpeed   - vertical speed
	 * @param color    - color of animal
	 * @param size     - size of animal
	 * @param img      - img url
	 * @param zoopanel - panel
	 */
	public Turtle(String name, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(name, new Point(80, 0), xSpeed, ySpeed, color, size, img, zoopanel, con);
		this.setAge(1);
		this.setDiet(new Herbivore());
	}

	/**
	 * Copy constructor for turtle
	 * 
	 * @param t - turtle
	 */
	public Turtle(Turtle t) {
		super(t);
		this.setAge(t.getAge());
	}

	/**
	 * clone method for turtle
	 * 
	 */
	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return new Turtle(this);
	}

	/**
	 * Getter for age
	 * 
	 * @return age
	 */
	public int getAge() {
		return this.Age;
	}

	/**
	 * Sound of Turtle
	 * 
	 * @return String of Turtle sound
	 */
	public void chew() {
	}

	/**
	 * Setter for age
	 * 
	 * @return if succeeded
	 */
	public boolean setAge(int age) {
		boolean isSuccses = false;
		if (0 < age && age <= 500) {
			isSuccses = true;
			this.Age = age;
		}
		return isSuccses;
	}

	/**
	 * equals for turtle
	 * 
	 * @param o - object
	 */
	@Override
	public boolean equals(Object o) {

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Turtle)) {
			return false;
		}

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		if (!super.equals(o))
			return false;

		// typecast o to Complex so that we can compare data members
		Turtle t = (Turtle) o;

		// Compare the data members and return accordingly
		return this.getAge() == t.getAge();
	}

	/**
	 * returns "Turtle" String
	 * 
	 */
	@Override
	public String getAnimalName() {
		return "Turtle";
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	@Override
	public void setWeightBySize(int size) {
		this.setWeight(size * 0.5);
	}

}
