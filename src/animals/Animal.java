package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import decorator.ChangeColor;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import observer.Controller;
import mobility.Line;

/**
 * A class that describes animal which inherited from Mobile
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see Mobile
 *
 */
public abstract class Animal extends Mobile
		implements IEdible, IAnimalBehavior, IDrawable, Runnable, ChangeColor, Cloneable {

	private String name;
	private double weight;
	private IDiet diet;
	public static final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged = false;
	private int x_dir = 1;
	private int y_dir = 1;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	private boolean threadSuspended;
	private boolean flag = true;
	private boolean eatflag = false;
	private boolean drawflag = false;
	private Controller con = new Controller(pan);
	/**
	 * Anonymous declaration for observer
	 */
	@SuppressWarnings("deprecation")
	private Observable ob = new Observable() {
		@Override
		public void notifyObservers(Object o) {
			super.setChanged();
			super.notifyObservers(o);
		}
	};

	/**
	 * Constructor for Animal
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
	public Animal(String name, Point p, int xSpeed, int ySpeed, String color, int size, String img, ZooPanel zoopanel,
			Controller con) {
		super(p);
		this.setName(name);
		this.setHorSpeed(xSpeed);
		this.setVerSpeed(ySpeed);
		this.setCol(color);
		this.setSize(size);
		this.setWeightBySize(size);
		this.loadImages(img);
		this.setPan(zoopanel);
		this.setCon(con);
		ob.addObserver(this.getCon());
	}

	/**
	 * "Copy" Constructor for Animal
	 * 
	 * @param a - animal
	 */
	public Animal(Animal a) {
		super(a.getLocation());
		this.setName(a.getName());
		this.setHorSpeed(a.getHorSpeed());
		this.setVerSpeed(a.getVerSpeed());
		this.setCol(a.getColor());
		this.setSize(a.getSize());
		this.setWeightBySize(a.getSize());
		this.loadImages(a.getClass().getSimpleName().substring(0, 3).toLowerCase());
		this.setPan(a.getPan());
		this.setCon(a.getCon());
		this.setEatCount(a.getEatCount());
		this.setThreadSuspended(a.isThreadSuspended());
		this.setDiet(a.getDiet());
		this.setEatflag(a.getEatflag());
		this.setDrawflag(a.isDrawable());
		this.setX_dir(a.getX_dir());
		this.setY_dir(a.getY_dir());
		this.setChanges(a.getChanges());
		ob.addObserver(this.getCon());
	}

	/**
	 * Clones animal object
	 * 
	 */
	@Override
	public synchronized Object clone() throws CloneNotSupportedException {
		return null;
	}

	/**
	 * abstract method for animal to make sound
	 */
	public  abstract void makeSound();

	public void changeColor() {
	}

	/**
	 * Method that simulates Animal eat
	 * 
	 * @param e - food
	 * @return boolean - if eaten
	 */
	public boolean eat(IEdible e) {
			boolean isSuccess = false;
			if (this.diet.canEat(e.getFoodtype())) {
				this.setWeight(this.getWeight() + diet.eat(this, e));
				this.eatInc();
				this.makeSound();
				isSuccess = true;
			}
			return isSuccess;
	}

	/**
	 * Method that simulates Animal move
	 * 
	 * @param p - Point to move to
	 * @return distance that animal moved
	 */
	@Override
	public double move(Point p) {
		double dis = super.move(p);
		return dis;
	}

	/**
	 * Getter for food type
	 * 
	 * @return food type
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.MEAT;
	}

	/**
	 * Getter for Animal name
	 * 
	 * @return name of the animal
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter for Animal name, can be set to null
	 * 
	 * @return if succeeded
	 */
	public boolean setName(String name) {
		boolean isSuccess = name != null;
		if (isSuccess)
			this.name = name;
		else
			this.name = new String("None");
		return isSuccess;
	}

	/**
	 * Getter for Animal weight
	 * 
	 * @return weight of the animal
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter for Animal weight
	 * 
	 * @return if succeeded
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = weight > 0;
		if (isSuccess)
			this.weight = weight;
		return isSuccess;
	}

	/**
	 * Getter for Animal diet
	 * 
	 * @return diet of the animal
	 */
	public IDiet getDiet() {
		return diet;
	}

	/**
	 * Setter for Animal diet
	 * 
	 * @return if succeeded
	 */
	public boolean setDiet(IDiet diet) {
		boolean isSuccess = diet != null;
		if (isSuccess)
			this.diet = diet;
		return isSuccess;
	}

	/**
	 * equals between two objects of underlying of this class
	 * 
	 * @param o - Object
	 * @return if equal
	 */
	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Animal or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Animal)) {
			return false;
		}

		// typecast o to Animal so that we can compare data members
		Animal a = (Animal) o;

		// Compare the data members and return accordingly
		return this.getWeight() == a.getWeight() && this.getName().equals(a.getName())
				&& this.getClass().getSimpleName().equals(a.getClass().getSimpleName());
	}

	/**
	 * return string that represent Animal
	 * 
	 * @return Animal string
	 */
	public String toString() {
		return String.format("[%s]: %s", this.getClass().getSimpleName(), this.getName());
	}

	/**
	 * Load images of Animal
	 * 
	 * @param nm - string
	 */
	@Override
	public void loadImages(String nm) {
		try {
			img1 = ImageIO.read(
					new File(IDrawable.PICTURE_PATH + nm + "_" + this.col.substring(0, 1).toLowerCase() + "_1.png"));
			img2 = ImageIO.read(
					new File(IDrawable.PICTURE_PATH + nm + "_" + this.col.substring(0, 1).toLowerCase() + "_2.png"));
		} catch (IOException ex) {
			System.out.println("Cannot find image");
		}

	}

	/**
	 * Draws image of Animal on the screen
	 * 
	 */
	@Override
	public void drawObject(Graphics g) {
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		if (getX_dir() == 1)
			g.drawImage(img1, x - size / 2, y - size / 10, size, size, pan);
		else
			g.drawImage(img2, x, y - size / 10, size, size, pan);
	}

	/**
	 * Getter for size
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter for Animal size
	 * 
	 * @param size - size of the animal
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Setter for Animal color
	 * 
	 * @param color - color of the animal
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * Getter for Animal horSpeed
	 * 
	 * @return horSpeed
	 */
	public int getHorSpeed() {
		return horSpeed;
	}

	/**
	 * Setter for Animal horSpeed
	 * 
	 * @param horSpeed - horizontal speed of the animal
	 */
	public void setHorSpeed(int horSpeed) {
		this.horSpeed = horSpeed;
	}

	/**
	 * Getter for Animal verSpeed
	 * 
	 * @return verSpeed
	 */
	public int getVerSpeed() {
		return verSpeed;
	}

	/**
	 * Setter for Animal verSpeed
	 * 
	 * @param verSpeed - vertical speed of the animal
	 */
	public void setVerSpeed(int verSpeed) {
		this.verSpeed = verSpeed;
	}

	/**
	 * Getter for eat count
	 * 
	 * @return eat count
	 */
	public int getEatCount() {
		return eatCount;
	}

	/**
	 * Setter for Animal eatCount
	 * 
	 * @param eatCount - eat count of the animal
	 */
	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}

	/**
	 * Getter for img1
	 * 
	 * @return img1
	 */
	public BufferedImage getImg1() {
		return img1;
	}

	/**
	 * Setter for Animal img1
	 * 
	 * @param img1 - img1 of the animal
	 */
	public void setImg1(BufferedImage img1) {
		this.img1 = img1;
	}

	/**
	 * Getter for img2
	 * 
	 * @return img2
	 */
	public BufferedImage getImg2() {
		return img2;
	}

	/**
	 * Setter for Animal img2
	 * 
	 * @param img2 - img2 of the animal
	 */
	public void setImg2(BufferedImage img2) {
		this.img2 = img2;
	}

	/**
	 * Increase eat counter by 1
	 * 
	 */
	@Override
	public synchronized void eatInc() {
		this.eatCount += 1;
	}

	@Override
	/**
	 * 
	 * @return if cord changed
	 */
	public boolean getChanges() {
		return this.coordChanged;
	}

	/**
	 * Setter for coordChanged
	 * 
	 * @param state - coordChanged of the animal
	 */
	@Override
	public void setChanges(boolean state) {
		this.coordChanged = state;
	}

	/**
	 * Getter for Animal color
	 * 
	 * @return Animal color
	 */
	@Override
	public String getColor() {
		return this.col;
	}

	/**
	 * Getter for Animal panel
	 * 
	 * @return Animal panel
	 */
	public ZooPanel getPan() {
		return pan;
	}

	/**
	 * Setter for Animal eatCount
	 * 
	 * @param eatCount - eat count of the animal
	 */
	public void setPan(ZooPanel pan) {
		this.pan = pan;
	}

	/**
	 * sets weight of animal by its size
	 * 
	 * @param size - size of animal
	 */
	public abstract void setWeightBySize(int size);

	/**
	 * resumed the threads
	 */
	@Override
	public synchronized void setResumed() {
		this.setThreadSuspended(false);
		this.notify();
	}

	/**
	 * Suspends the threads
	 */
	@Override
	public synchronized void setSuspended() {
		this.setThreadSuspended(true);
	}

	/**
	 * manage the threads run,makes the animal move on the screen
	 */
	@Override
	public void run() {
		if (!this.isDrawable())
			this.setDrawflag(true);
		while (flag) {
			if (!this.isThreadSuspended()) {
				if (eatflag) {
					this.moveTowardsFood();
					ob.notifyObservers(); // notify
				} else {

					this.moveInSpace();
					ob.notifyObservers();
				}

				this.pan.repaint();
			} else {
				try {
					synchronized (this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					System.out.println("Cant wait");
				}
			}
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				System.out.println("Cant sleep");
			}
		}
	}

	/**
	 * sets flag of thread to false = kills thread.
	 * 
	 */
	public void stop() {
		this.flag = false;
	}

	/**
	 * Getter for x_dir
	 * 
	 * @return x direction
	 */
	public int getX_dir() {
		return x_dir;
	}

	/**
	 * Setter for x_dir
	 * 
	 * @param x_dir - x direction
	 */
	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}

	/**
	 * Getter for y_dir
	 * 
	 * @return y direction
	 */
	public int getY_dir() {
		return y_dir;
	}

	/**
	 * Setter for x_dir
	 * 
	 * @param y_dir - y direction
	 */
	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}

	/**
	 * returns the state of threadSuspended
	 * 
	 * @return
	 */
	public boolean isThreadSuspended() {
		return threadSuspended;
	}

	/**
	 * setter for threadsuspended
	 * 
	 * @param threadSuspended
	 */
	public void setThreadSuspended(boolean threadSuspended) {
		this.threadSuspended = threadSuspended;
	}

	/**
	 * function that rotates the animal to the direction of the food
	 * 
	 * @param x - x position
	 * @param y - y position
	 */
	public void rotateToFood(int x, int y) {
		if (y > 265 && y_dir == 1)
			y_dir = -1;
		if (y < 265 && y_dir == -1)
			y_dir = 1;
		if (x < 355 && x_dir == -1)
			x_dir = 1;
		if (x > 355 && x_dir == 1)
			x_dir = -1;
	}

	/**
	 * function that moves the animal towards the food
	 * 
	 */
	public void moveTowardsFood() {
		int newx = 0, newy = 0;
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		int speedX = this.getHorSpeed() * this.getX_dir();
		int speedY = this.getVerSpeed() * this.getY_dir();
		Point center = new Point(ZooPanel.screenwidth, ZooPanel.screenheight);
		this.rotateToFood(x, y);
		double incline = Line.calcIncline(this.getLocation(), center);
		Line line = new Line(this.getLocation(), incline);
		if (incline == 0 && x == ZooPanel.screenwidth) {
			if (y < ZooPanel.screenheight) {
				newx = ZooPanel.screenwidth;
				newy = y + 5;
			} else {
				newx = ZooPanel.screenwidth;
				newy = y - 5;
			}
		} else if (incline == 0 && y == ZooPanel.screenheight) {
			if (x < ZooPanel.screenwidth) {
				newx = x + 5;
				newy = ZooPanel.screenheight;
			} else {
				newx = x - 5;
				newy = ZooPanel.screenheight;
			}
		} else {
			newx = x + speedX;
			newy = line.returnY(newx);
		}
		this.move(new Point(newx, newy));
	}

	/**
	 * function that moves the animal on the screen
	 */
	public void moveInSpace() {
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		if (x >= 750) {
			this.setX_dir(-1); // change direction
			x = 750;
		}
		if (x <= 0) {
			this.setX_dir(1); // change direction
			x = 0;
		}
		if (y >= 500) {
			this.setY_dir(-1); // change direction
			y = 500;
		}

		if (y <= 0) {
			this.setY_dir(1); // change direction
			y = 0;
		}
		int newx = x + this.getHorSpeed() * this.getX_dir();
		int newy = y + this.getVerSpeed() * this.getY_dir();
		this.move(new Point(newx, newy));
	}

	/**
	 * setter for eat flag
	 * 
	 * @param eatflag
	 */
	public void setEatflag(boolean eatflag) {
		this.eatflag = eatflag;
	}

	/**
	 * getter for eat flag
	 * 
	 * @param eatflag
	 */
	public boolean getEatflag() {
		return this.eatflag;
	}
    
	/**
	 * Drawable flag for animal
	 * 
	 * @return
	 */
	public boolean isDrawable() {
		return drawflag;
	}

	/**
	 * setter for draw flag
	 * 
	 * @param drawflag
	 */
	public void setDrawflag(boolean drawflag) {
		this.drawflag = drawflag;
	}

	/**
	 * getter for animal controller
	 * 
	 * @return controller
	 */
	public Controller getCon() {
		return con;
	}

	/**
	 * setter for animal controller
	 * 
	 * @param con -  controller
	 */
	public void setCon(Controller con) {
		this.con = con;
	}

}
